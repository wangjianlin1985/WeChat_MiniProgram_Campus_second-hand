var app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    tel:'',
    address:'',
    uid:0,
    editAddress:[]
  },
  //表单提交
  formSubmit: function (e) {
   
    const id = app.globalData.user.user.uid //在全局变量中 获取用户的id
    this.data.uid = id  //将id赋给uid
    // console.log(e.detail.value.telephone)
    // console.log(this.data.uid)
    wx.request({
      url: '' + app.globalData.URL + '/addAddress.do',
      method: 'POST',
      data: {
        tel: e.detail.value.telephone,
        address: e.detail.value.address,
        uid: this.data.uid,
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: res => {
        
        wx.navigateBack({
          
        })
        wx.showToast({
          title: '添加地址成功',
        })
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    if (options.aid != null) {

      this.data.aid = options.aid
      //console.log(this.data.aid)

      wx.request({
        url: '' + app.globalData.URL + '/findOneAddress.do?aid=' + this.data.aid + '',
        method: 'GET',
        data: {
        },
        header: {
          'content-type': 'application/json' // 默认值
        },
        success: res => {
          //console.log(res.data.info) 地址的详细信息
          this.setData({
            editAddress: res.data.info
          })
        }
      })
    }
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
    
  }
})
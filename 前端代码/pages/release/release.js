var app = getApp()


Page({

  /**
   * 页面的初始数据
   */
  data: {
   gimage:'',
   gname:'',
   gprice:'',
   gdesc:'',
   gnum:'',
   uid:''
  },

  //添加图片
  chooseImageTap: function (options){
    if (app.globalData.user.user == null) {
      wx.showToast({
        title: '请先登录',
        icon: 'none',
        duration: 2000
      })
    } else{
      var that = this;
      wx.chooseImage({
        count: 1,
        sizeType: ['compressed'],
        sourceType: ['ablum', 'camera'],//从相册中选择和从拍照中选择
        success: function (res) {
          var gimage = res.tempFilePaths;
          //console.log(gimage)
          that.setData({
            gimage: gimage,
          }),
            app.globalData.gimagepath = that.data.gimage //将上传图片的路径写入全局变量
          // console.log(app.globalData.gimagepath)
          // console.log(app.globalData.user.user.uid)
        },
      })
    }
    
  },
  //表单提交
  formSubmit:function(e){
    if (app.globalData.user.user == null) {
      wx.showToast({
        title: '请先登录',
        icon: 'none',
        duration: 2000
      })
    } else {
      // console.log(e.detail.value)
      wx.request({
        url: '' + app.globalData.URL + '/addGoods.do',
        method: 'POST',
        data: {
          gname: e.detail.value.gname,
          gprice: e.detail.value.gprice,
          gdesc: e.detail.value.gdesc,
          gnum: e.detail.value.gnum,
          gimage: app.globalData.gimagepath,
          uid: app.globalData.user.user.uid
        },
        header: {
          "Content-Type": "application/x-www-form-urlencoded"
        },

        success: res => {

          wx.switchTab({
            url: '../index/index',
            success: function (res) {
              wx.showToast({
                title: '发布成功',
                icon: 'none',
                duration: 2000
              })
            },
            fail: function (res) { },
            complete: function (res) { },
          })
        }
      })
    }
    
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
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
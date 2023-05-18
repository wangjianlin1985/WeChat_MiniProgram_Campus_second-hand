var app = getApp()


// pages/buygoods/buygoods.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    address:[],
    buyProduct:[],
    oid:'',
  },


  //选择收货地址
  switchAddress: function (e) {
    wx.navigateTo({
      url: '/pages/address/address?flag=1',
    })
  },

  //給卖家留言
  leaveMessageInput: function (e) {
    this.setData({
      leaveMessage: e.detail.value
    })
  },

  //获取当前时间
  getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
    var strDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
      + " " + date.getHours() + seperator2 + date.getMinutes()
      + seperator2 + date.getSeconds();
    return currentdate;
  },

  //提交订单
  submitOrder:function(e) {
    var currentDate = this.getNowFormatDate()

    // console.log(currentDate)
    // console.log(this.data.buyProduct.gprice)
    // console.log(app.globalData.user.user.uid)
    // console.log(app.globalData.chooseAddres)

    wx.request({
      url: '' + app.globalData.URL + '/addOrder.do',
      method:"POST",
      data:{
        createtime: currentDate, //订单的创建时间
        price: this.data.buyProduct.gprice,
        uid:app.globalData.user.user.uid,
        gid: this.data.buyProduct.gid,
        gstatus:0 , //0 表示订单创建，但是没有发货，发货为1 ，
        aid: app.globalData.chooseAddres.aid
      },

      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: res => {
        wx.showToast({
          title: '购买成功',
          icon: 'none',
          duration: 2000
        })
      },
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //获取详情页传来的gid
   // console.log(options.gid) 
    //加载选中购买的商品
    var that = this
    wx.request({
      url: '' + app.globalData.URL + '/findOneGood.do?gid=' + options.gid,
      method: 'GET',
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: res => {
        //console.log(res.data.info)
        this.setData({
          buyProduct: res.data.info
        })
        //console.log(this.data.product.gid)
      }
    })
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
    //console.log(app.globalData.chooseAddres)
    this.setData({
      address: app.globalData.chooseAddres
    })
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
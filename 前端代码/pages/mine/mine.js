var app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
   user: [], 
  },
//退出按钮的事件
 loginout:function(e) {
   if (this.data.user.length != 0) {
     this.setData({
       user: '' //将user复制为空
     })
     app.globalData.user.user == null
     wx.navigateTo({
       url: '/pages/mine/mine',
     })
   }
 },
 //点击我买过的
  goOrder:function(e) {
   // console.log(app.globalData.user.user.uid)
    let index = e.target.dataset.index
    if (app.globalData.user.length == 0) {
      wx.showToast({
        title: '请登录',
        icon: 'none',
        duration: 2000
      })
    } else {
      
      let uid = app.globalData.user.user.uid
      wx.navigateTo({
        url: '/pages/orders/orders?item=' + index,
      })
    }
  },

  //带收获的和待发货的
  goOrderIndex:function(e){
    
    let index = e.target.dataset.index
    //console.log(index)
    if (app.globalData.user.length == 0) {
      wx.showToast({
        title: '请登录',
        icon: 'none',
        duration: 2000
      })
    } else{
      wx.navigateTo({
        url: '/pages/orders/orders?item='+index,
      })
    }
    
  },

  // 我发布的上平
  goMyreleased:function(){
    if (app.globalData.user.length == 0) {
      wx.showToast({
        title: '请登录',
        icon: 'none',
        duration: 2000
      })
    } else {
      wx.navigateTo({
        url: '/pages/myreleased2/myreleased2',
      })
    }
    
  },

  sorry:function() {
    if (app.globalData.user.length == 0) {
      wx.showToast({
        title: '请登录',
        icon: 'none',
        duration: 2000
      })
    } else {
      wx.showToast({
        title: '先功能正在研发',
        icon: 'none',
        duration: 2000
      })
    }
    
  },

  managerAddress:function(e){
    if (app.globalData.user.length == 0) {
      wx.showToast({
        title: '请登录',
        icon: 'none',
        duration: 2000
      })
    } else {
      let uid = app.globalData.user.user.uid
      wx.navigateTo({
        url: '/pages/address/address',
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
    // console.log(this.data.user.length)
    // console.log(app.globalData.user)
    if (this.data.user.length == 0) {
      this.setData({
        user: app.globalData.user //把全局变量赋值给该页面
      })
    }
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
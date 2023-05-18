var app = getApp()

Page({
  /**
   * 页面的初始数据
   */
  data: {
    username: '',
    password: '',
    user: [],
    haslogin:false
  },

  formSubmit: function (e) {
    // 
    // console.log(e.detail.value)
    wx.request({
      url: '' + app.globalData.URL + '/user/login.do',
      method: 'POST',
      data: {
        username: e.detail.value.username,
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },

      success: res => {
        //console.log(res.data)
        this.setData({
          user: res.data.info
        })

        app.globalData.user = this.data  //将登录信息 写入到全局变量中 

        //console.log(app.globalData.user)
        //const username = res.data.info.username
        //console.log(username)
        //const pwd = res.data.info.password
        if (app.globalData.user.user == null) {
          //没有此联系人
          wx.showModal({
            title: '提示',
            content: '用户名不存在',
            showCancel: false,
            cancelColor: 'red'
          })
        } else {
          //联系人有，验证密码
          if (e.detail.value.password == app.globalData.user.user.password) {
            wx.switchTab({
              url: '../index/index',
              success: function (res) { 
                wx.showToast({
                  title: '登录成功',
                  icon: 'none',
                  duration: 2000
                })
              },
              fail: function (res) { },
              complete: function (res) { },
            })
          } else {
            wx.showModal({
              title: '提示',
              content: '密码错误',
              showCancel: false
            })
          }

        }

      }

    })

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
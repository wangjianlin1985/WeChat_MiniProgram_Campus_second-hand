var app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    username: '',
    password: ''
  },


  /**
 * 绑定的函数
 */
  formSubmit: function (e) {
    //console.log(e.detail.value)
    const userName = e.detail.value.username;
    const passWord = e.detail.value.password;
    if (userName != '' && passWord != '') {
      this.setData({
        username: userName,
        password: passWord
      });
    } else {
      wx.showModal({
        title: '提示',
        content: '请将信息填写完整',
      })
    }

    //提交到服务器端
    wx.request({
      url: '' + app.globalData.URL + '/addUser.do',
      method: 'POST',
      data: {
        username: userName,
        password: passWord
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: res => {
        //console.log(res.data)
        if (res.data.code == 0) {
          //该用户名已被注册
          wx.showModal({
            title: '提示',
            content: '该用户名已被注册',
          })
        } else {
          wx.showModal({
            title: '提示',
            content: '注册成功,跳转登录界面',
            success: function (res) {
              if (res.cancel) {
                //点击取消,默认隐藏弹框
              }
              if (res.confirm) {
                //点击确定，跳转到登录界面
                wx.navigateTo({
                  url: '../login/login',
                })
              }
            }
          })
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
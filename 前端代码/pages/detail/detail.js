//获取应用实例
const app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    product: [],
    gname:'',
    gimage:'',
    gprice:'',
    gnum:'',
    gdesc:'',
    uid:'',
    gid:''
  },

  //加入收藏的函数
  collect: function (e) {
    //console.log(app.globalData.user)
    if (app.globalData.user.user == null) {
      wx.showModal({
        title: '提示',
        content: '请先登录',

        success: function (res) {
          if (res.cancel) {

          } else {
            //去登录界面
            wx.navigateTo({
              url: '/pages/login/login',
            })
          }
        }
      })
    } else {
      //console.log(this.data.product.gid)
      wx.request({
        url: '' + app.globalData.URL + '/addCollection.do',
        method: 'POST',
        data: {
          gid: this.data.product.gid,
          uid: app.globalData.user.user.uid
        },
        header: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        success: res => {
          // console.log("成功！")
          wx.showToast({
            title: '收藏成功',
            icon: 'none',
            duration: 2000
          })
        }
      })
      
    }
  },

  //购买
  buy:function(e){
    //console.log(app.globalData.user)
    if (app.globalData.user.user == null) {
      wx.showModal({
        title: '提示',
        content: '请先登录',

        success: function (res) {
          if (res.cancel) {

          } else {
            //去登录界面
            wx.navigateTo({
              url: '/pages/login/login',
            })
          }
        }
      })
    } else {
      //跳转到购买页面
      //console.log(this.data.product.gid)
      wx.navigateTo({
        url: '/pages/buygoods/buygoods?gid=' + this.data.product.gid,
      })
    }
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // console.log(app.globalData.URL) 
    // console.log(options.item)
    var that = this
    wx.request({
      url: '' + app.globalData.URL + '/findOneGood.do?gid=' + options.item,
      method: 'GET',
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: res => {
        //console.log(res.data)
        this.setData({
          product: res.data.info
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
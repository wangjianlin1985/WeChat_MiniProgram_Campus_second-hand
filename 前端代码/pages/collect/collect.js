var app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    buyProduct: [],
    isAllSelect: false,
    totalMoney: 0,
    collections: [],//收藏架集合
    uid:'',
  },



  //移除收藏的商品
  removeHandle: function (e) {
    var that = this
    //console.log('移除按钮' + e.target.dataset.index)
    let index = e.target.dataset.index
    //console.log(this.data.collections[index])
    let cid = this.data.collections[index].cid
    //console.log(cid)
    wx.request({
      url: '' + app.globalData.URL + '/removeCollection.do?cid=' + cid + '',
      method: 'GET',
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: res => {
        wx.showToast({
          title: '删除成功',
          icon: 'none',
          duration: 2000
        })
        this.onShow()
      }
    })

  },

  //选择商品
  switchSelect: function (e) {
   // console.log(e.target.dataset.index)
    let id = e.target.dataset.id;
    var allPrice = 0;
    var i = 0;
    var index = parseInt(e.target.dataset.index);
    // console.log(index)
    //console.log(this.data.collections[index].isselect)   

    if (this.data.collections[index].isselect == 0) {
      this.data.collections[index].isselect = false;
    }
    if (this.data.collections[index].isselect == 1) {

      this.data.collections[index].isSelect = true;

    }

    this.data.collections[index].isSelect = !this.data.collections[index].isSelect;
    //console.log(this.data.collections[index].isSelect)

    //价钱统计
    if (this.data.collections[index].isSelect) {
      this.data.totalMoney = this.data.totalMoney + this.data.collections[index].gprice ;
    } else {
      this.data.totalMoney = this.data.totalMoney - this.data.collections[index].gprice;
    }

    //是否全选判断
    for (i = 0; i < this.data.collections.length; i++) {
      allPrice = allPrice + this.data.collections[i].gprice;
    } if (allPrice == this.data.totalMoney) {
      this.data.isAllSelect = true;
    } else {
      this.data.isAllSelect = false;
    }
    this.setData({
      collections: this.data.collections,
      totalMoney: this.data.totalMoney,
      isAllSelect: this.data.isAllSelect,
    })
  },

  //处理全选
  allSelect: function (e) {
    let i = 0;
    if (!this.data.isAllSelect) {
      for (i = 0; i < this.data.collections.length; i++) {
        this.data.collections[i].isSelect = true;
        this.data.totalMoney = this.data.totalMoney + this.data.collections[i].gprice ;
      }
    } else {
      for (i = 0; i < this.data.collections.length; i++) {
        this.data.collections[i].isSelect = false;
      }
      this.data.totalMoney = 0;
    }
    this.setData({
      collections: this.data.collections,
      isAllSelect: !this.data.isAllSelect,
      totalMoney: this.data.totalMoney,
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
    if (null == app.globalData.user.user) {
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
    } else{

      if (app.globalData.user == null) {
        this.data.collections = '';
      } else {
        //console.log(app.globalData.user.user.uid)
        wx.request({
          url: '' + app.globalData.URL + '/findCollectionByUid.do',
          method: 'GET',
          data: {
            uid: app.globalData.user.user.uid
          },
          header: {
            'content-type': 'application/json' // 默认值
          },
          success: res => {
            //console.log(res.data.info)
            this.setData({
              totalMoney: 0,
              collections: res.data.info
            })
          }
        })
      }
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
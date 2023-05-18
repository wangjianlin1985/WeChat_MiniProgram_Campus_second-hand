var app =getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    address: [],
    flag: 0,
    uid:'',
    tel:'',
  },

  //选择地址
  selectAddress: function (e) {
    const index = e.target.dataset.index //选中的那一项的下标(0开始)

    let address = this.data.address[index]
    // console.log(address)
    // console.log(this.data.address[index].aid)
    
    let pages = getCurrentPages();
    let prePage = pages[pages.length - 2]
    //将选中的地址传给全局变量
    app.globalData.chooseAddres = address 
    wx.navigateBack({

    })
  },


  


  //删除地址
  deleteAddress: function (e) {
    //console.log(e.target.dataset.id)


    let index = e.target.dataset.id //记录下标

    let aid = this.data.address[index].aid//记录某地址的aid

    var that = this
    wx.showModal({
      title: '提示',
      content: '确定要删除？',
      success: function (res) {
        if (res.cancel) {
          //点击取消,默认隐藏弹框
        }
        if (res.confirm) {
          // console.log(aid)
          wx.request({
            url: '' + app.globalData.URL + '/deleteAddress.do?aid=' + aid + '',
            method: 'GET',
            data: {
            },
            header: {
              'content-type': 'application/json' // 默认值
            },
            success: res => {
              //this.onLoad()
              that.onShow()
            }
          })
        }
      }
    })
  },


//编辑地址
  editAddress: function (e) {
    //
    let index = e.target.dataset.id //记录下标

    let aid = this.data.address[index].aid//记录某地址的aid

    //  var choiceAddress = this.data.address[index]
    wx.navigateTo({
      url: '/pages/addaddress/addaddress?aid=' + aid,
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    if (options.flag != null) {
      this.setData({
        flag: options.flag
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
    wx.request({
      url: '' + app.globalData.URL + '/findAddressById.do' ,
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
         
          address: res.data.info
        })
      }
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
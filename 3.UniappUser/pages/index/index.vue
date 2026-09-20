<template>
<view class="content">
	<view :style='{"width":"100%","padding":"20rpx 20rpx 100rpx","background":"#CFE3FA","flexDirection":"column","display":"flex","height":"auto"}'>
		<swiper :style='{"width":"100%","background":"#fff","height":"360rpx"}' class="swiper" :indicator-dots='true' :autoplay='true' :circular='true' indicator-active-color='#000000' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='5000' :vertical='false'>
			<swiper-item :style='{"width":"100%","background":"#fff","height":"360rpx"}' v-for="(swiper,index) in swiperList" :key="index" @tap="onSwiperTap(swiper)">
				<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" :src="baseUrl+swiper.img"></image>
				<view v-if="false" :style='{"width":"100%","padding":"0 8rpx","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","background":"#fff"}'>{{ swiper.title }}</view>
			</swiper-item>
		</swiper>
		<!-- menu -->
		<view v-if="true" class="menu" :style='{"padding":"40rpx 0","margin":"40rpx 0 0","borderRadius":"28rpx","flexWrap":"wrap","background":"#EBF7FF url(http://codegen.caihongy.cn/20240119/4df6cbf6f8154915a2ee5812e40f1393.webp)no-repeat 0 0/100% 128rpx","display":"flex","width":"100%","height":"auto"}'>
            <block v-for="(item,index1) in menuList" v-bind:key="item.roleName">
                <block v-if="index1==0" v-bind:key="index" v-for=" (menu,index) in item.frontMenu">
                    <block v-bind:key="sort" v-for=" (child,sort) in menu.child">
                        <block v-bind:key="sort2" v-for=" (button,sort2) in child.buttons">
                            <view :style='{"width":"25%","padding":"12rpx 0","margin":"10rpx 0","height":"auto"}' class="menu-list" v-if="button=='查看' && child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' " @tap="onPageTap2(child.tableName)">
                                <view class="iconarr" :class="child.appFrontIcon" :style='{"padding":"0","margin":"0px auto","color":"#6AB6EC","borderRadius":"100%","display":"block","width":"56rpx","lineHeight":"56rpx","fontSize":"56rpx","height":"56rpx"}'></view>
                                <view :style='{"padding":"0","margin":"24rpx auto 0","color":"#6AB6EC","textAlign":"center","width":"100%","lineHeight":"28rpx","fontSize":"28rpx"}'>{{child.menu.split("列表")[0]}}</view>
                            </view>
                        </block>
                    </block>
                </block>
            </block>
		</view>
		<!-- menu -->
		<!-- 商品推荐 -->
		<!-- 商品推荐 -->
		
		<!-- 商品列表 -->
		<view class="listBox list" :style='{"margin":"40rpx 0 0","borderRadius":"20rpx","background":"#EBF7FF","order":"5"}'>
			<view class="title" :style='{"padding":"0 24rpx","margin":"0","overflow":"hidden","borderRadius":"20rpx 20rpx 0 0","background":"url(http://codegen.caihongy.cn/20240119/bc8777357a2c4611be5846b354d2a5b2.webp)no-repeat 0 0 /100% 100%","display":"flex","width":"100%","justifyContent":"space-between","height":"100rpx"}'>
				<view :style='{"color":"#fff","fontSize":"32rpx","lineHeight":"88rpx"}'>课程信息</view>
				<view :style='{"display":"flex"}' @tap="onPageTap('kechengxinxi')">
				  <text :style='{"color":"#fff","fontSize":"24rpx","lineHeight":"44rpx"}'>更多</text>
				  <text class="icon iconfont icon-gengduo1" :style='{"color":"#fff","fontSize":"24rpx","lineHeight":"44rpx"}'></text>
				</view>
			</view>
			<view id="list-list-10" class="list-box10 waterfall-body" :style='{"width":"100%","padding":"20rpx 24rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}'>
				<view id="waterfall-left-column-list-10kechengxinxi" class="waterfall-column-list-10" :style='{"margin":"0 12rpx 0 0","flex":"1","flexDirection":"column","display":"flex"}'>
					<view @tap="onDetailTap('kechengxinxi',product.id)" :style='{"boxShadow":"0 2rpx 16rpx rgba(0,0,0,.3)","margin":"0 0 20rpx 0","overflow":"hidden","position":"relative","borderRadius":"12rpx"}' v-for="product in leftListList10kechengxinxi" :key="product.id" class="left-content">
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"auto"}' mode="widthFix" v-if="product.tupian.substring(0,4)=='http'" :src="product.tupian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"auto"}' mode="widthFix" v-else :src="product.tupian?baseUrl+product.tupian.split(',')[0]:''"></image>
						<view :style='{"width":"100%","background":"rgba(0,0,0,.3)"}'>
							<view :style='{"padding":"0 20rpx","lineHeight":"1.5","fontSize":"28rpx","color":"#fff"}' class="list-item-title">{{product.kechengmingcheng}}</view>
							<view :style='{"padding":"0 20rpx","lineHeight":"1.5","fontSize":"28rpx","color":"#fff"}' class="list-item-title">{{product.kechengleixing}}</view>
							<view :style='{"padding":"0 20rpx"}'>
								<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
								<text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.addtime}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
								<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
								<text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.gonghao}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
								<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
								<text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.storeupnum}}</text>
							</view>
						</view>
					</view>
				</view>
				
				<view id="waterfall-right-column-list-10kechengxinxi" class="waterfall-column-list-10" :style='{"margin":"0 0 0 12rpx","flex":"1","flexDirection":"column","display":"flex"}'>
					<view @tap="onDetailTap('kechengxinxi',product.id)" :style='{"boxShadow":"0 2rpx 16rpx rgba(0,0,0,.3)","margin":"0 0 20rpx 0","overflow":"hidden","position":"relative","borderRadius":"12rpx"}' v-for="product in rightListList10kechengxinxi" :key="product.id" class="right-content">
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"auto"}' mode="widthFix" v-if="product.tupian.substring(0,4)=='http'" :src="product.tupian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"auto"}' mode="widthFix" v-else :src="product.tupian?baseUrl+product.tupian.split(',')[0]:''"></image>
						<view :style='{"width":"100%","background":"rgba(0,0,0,.3)"}'>
							<view :style='{"padding":"0 20rpx","lineHeight":"1.5","fontSize":"28rpx","color":"#fff"}' class="list-item-title">{{product.kechengmingcheng}}</view>
							<view :style='{"padding":"0 20rpx","lineHeight":"1.5","fontSize":"28rpx","color":"#fff"}' class="list-item-title">{{product.kechengleixing}}</view>
							<view :style='{"padding":"0 20rpx"}'>
								<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
								<text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.addtime}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
								<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
								<text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.gonghao}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
								<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
								<text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.storeupnum}}</text>
							</view>
						</view>
					</view>
				</view>
			</view>
		</view>
		<!-- 商品列表 -->
		<!-- 新闻资讯 -->
		<view class="listBox news" :style='{"margin":"40rpx 0 0","borderRadius":"20rpx","background":"#EBF7FF","order":"3"}'>
			<view class="title" :style='{"padding":"0 24rpx","margin":"0","overflow":"hidden","borderRadius":"20rpx 20rpx 0 0","background":"url(http://codegen.caihongy.cn/20240119/bc8777357a2c4611be5846b354d2a5b2.webp)no-repeat 0 0 /100% 100%","display":"flex","width":"100%","justifyContent":"space-between","height":"100rpx"}'>
				<view :style='{"fontSize":"36rpx","lineHeight":"80rpx","color":"#fff","fontWeight":"700"}'>公告信息</view>
				<view :style='{"display":"flex"}' @tap="onPageTap('news')">
				  <text :style='{"color":"#fff","fontSize":"24rpx","lineHeight":"44rpx"}'>更多</text>
				  <text class="icon iconfont icon-gengduo1" :style='{"color":"#fff","fontSize":"24rpx","lineHeight":"44rpx"}'></text>
				</view>
			</view>
		  <!-- 样式7 -->
		  <view class="news-box4" :style='{"width":"100%","padding":"24rpx","margin":"0","height":"auto"}'>
			<block v-for="(item,index) in news" :key="index">
			  <view @tap="onNewsDetailTap(item.id)" v-if="index%2==0" class="list-item" :style='{"minHeight":"212rpx","padding":"20rpx 20rpx 20rpx 280rpx","margin":"0 0 20rpx","borderRadius":"12rpx","flexWrap":"wrap","background":"#FFFFFF","display":"flex","width":"100%","position":"relative","height":"auto"}'>
				<image :style='{"objectFit":"cover","borderRadius":"12rpx","left":"20rpx","display":"block","width":"240rpx","position":"absolute","height":"170rpx"}' mode="aspectFill" class="listmpic" :src="baseUrl+item.picture"></image>
				<view class="list-item-body" :style='{"padding":"0","margin":"0","height":"auto"}'>
				  <view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"1.5","fontSize":"28rpx","textOverflow":"ellipsis"}' class="title ">{{item.title}}</view>
				  <view :style='{"padding":"0 20rpx","margin":"0","whiteSpace":"nowrap","overflow":"hidden","color":"#666","display":"none","width":"100%","lineHeight":"1.5","fontSize":"24rpx","textOverflow":"ellipsis"}' class="text">{{item.introduction}}</view>
				  <view :style='{"padding":"0 20rpx"}'>
				    <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
				    <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.addtime}}</text>
				  </view>
				  <view :style='{"padding":"0 20rpx"}'>
				    <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
				    <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.name}}</text>
				  </view>
				  <view :style='{"padding":"0 20rpx","margin":"0 4rpx","borderRadius":"8rpx","background":"#C6E0F9","display":"inline-block"}'>
				    <text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#6991BC"}'></text>
				    <text :style='{"color":"#6991BC","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.thumbsupnum}}</text>
				  </view>
				  <view :style='{"padding":"0 20rpx","margin":"0 4rpx","borderRadius":"8rpx","background":"#C6E0F9","display":"inline-block"}'>
				    <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#6991BC"}'></text>
				    <text :style='{"color":"#6991BC","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.storeupnum}}</text>
				  </view>
				  <view :style='{"padding":"0 20rpx","backgroundColor":"#C6E0F9","margin":"0 4rpx","borderRadius":"8rpx","display":"inline-block"}'>
				    <text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#6991BC"}'></text>
				    <text :style='{"color":"#6991BC","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.clicknum}}</text>
				  </view>
				</view>
			  </view>
			  <view @tap="onNewsDetailTap(item.id)" v-if="index%2==1" class="list-item" :style='{"minHeight":"212rpx","padding":"20rpx 280rpx 20rpx 20rpx","margin":"0 0 20rpx","borderRadius":"12rpx","flexWrap":"wrap","background":"#FFFFFF","display":"flex","width":"100%","position":"relative","height":"auto"}'>
				<view class="list-item-body" :style='{"padding":"0","margin":"0","height":"auto"}'>
				  <view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"1.5","fontSize":"28rpx","textOverflow":"ellipsis"}' class="title ">{{item.title}}</view>
				  <view :style='{"padding":"0 20rpx","margin":"0","color":"#666","display":"none","width":"100%","lineHeight":"1.5","fontSize":"28rpx"}' class="text">{{item.introduction}}</view>
				  <view :style='{"padding":"0 20rpx"}'>
				    <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
				    <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.addtime}}</text>
				  </view>
				  <view :style='{"padding":"0 20rpx"}'>
				    <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
				    <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.name}}</text>
				  </view>
				  <view :style='{"padding":"0 20rpx","margin":"0 4rpx","borderRadius":"8rpx","background":"#C6E0F9","display":"inline-block"}'>
				    <text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#6991BC"}'></text>
				    <text :style='{"color":"#6991BC","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.thumbsupnum}}</text>
				  </view>
				  <view :style='{"padding":"0 20rpx","margin":"0 4rpx","borderRadius":"8rpx","background":"#C6E0F9","display":"inline-block"}'>
				    <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#6991BC"}'></text>
				    <text :style='{"color":"#6991BC","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.storeupnum}}</text>
				  </view>
				  <view :style='{"padding":"0 20rpx","margin":"0 4rpx","borderRadius":"8rpx","background":"#C6E0F9","display":"inline-block"}'>
				    <text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
				    <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.clicknum}}</text>
				  </view>
				</view>
				<image :style='{"objectFit":"cover","borderRadius":"12rpx","display":"block","width":"240rpx","position":"absolute","right":"20rpx","height":"170rpx"}' mode="aspectFill" class="listmpic" :src="baseUrl+item.picture"></image>
			  </view>
			</block>
		  </view>
		</view>
		<!-- 新闻资讯 -->
	</view>
</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
				iconArr: [
				  'cuIcon-same',
				  'cuIcon-deliver',
				  'cuIcon-evaluate',
				  'cuIcon-shop',
				  'cuIcon-ticket',
				  'cuIcon-cascades',
				  'cuIcon-discover',
				  'cuIcon-question',
				  'cuIcon-pic',
				  'cuIcon-filter',
				  'cuIcon-footprint',
				  'cuIcon-pulldown',
				  'cuIcon-pullup',
				  'cuIcon-moreandroid',
				  'cuIcon-refund',
				  'cuIcon-qrcode',
				  'cuIcon-remind',
				  'cuIcon-profile',
				  'cuIcon-home',
				  'cuIcon-message',
				  'cuIcon-link',
				  'cuIcon-lock',
				  'cuIcon-unlock',
				  'cuIcon-vip',
				  'cuIcon-weibo',
				  'cuIcon-activity',
				  'cuIcon-friendadd',
				  'cuIcon-friendfamous',
				  'cuIcon-friend',
				  'cuIcon-goods',
				  'cuIcon-selection'
				],
                role : '',
                menuList: [],
                swiperMenuList:[],
                user: {},
                tableName:'',

				//轮播
				swiperList: [],
				homekechengxinxilist: [],
				news: [],
				leftListList10kechengxinxi: [],
				rightListList10kechengxinxi: [],
				tempListList10kechengxinxi: [],
			}
		},
		watch: {
			copyFlowListList10kechengxinxi(nVal, oVal) {
				this.tempListList10kechengxinxi = this.cloneData(this.copyFlowListList10kechengxinxi);
				this.splitDataList10kechengxinxi();
			},
		},
		mounted() {
			this.tempListList10kechengxinxi = this.cloneData(this.copyFlowListList10kechengxinxi);
			this.splitDataList10kechengxinxi();
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
			copyFlowListList10kechengxinxi() {
				return this.cloneData(this.homekechengxinxilist);
			},
		},
        async onLoad(){
            
        },
		async onShow() {
			this.swiperMenuList = []
			this.role = uni.getStorageSync("appRole");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			this.menuList = menus;
			this.menuList.forEach((item,key) => {
			    if(key==0) {
			        item.frontMenu.forEach((item2,key2) => {
			            if(item2.child[0].buttons.indexOf("查看")>-1) {
			                this.swiperMenuList.push(item2);
			            }
			        })
			    }
			})
            // let res;
			// 轮播图
			let swiperList = []
			res = await this.$api.list('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
                        title: item.name,
						url: item.url
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
			

			this.leftListList10kechengxinxi = []
			this.rightListList10kechengxinxi = []
			this.tempListList10kechengxinxi = []
			this.getRecommendList()
			this.getHomeList()
			this.getNewsList()
		},
		methods: {
			async splitDataList10kechengxinxi() {
				if (!this.tempListList10kechengxinxi.length) return;
				let leftRect = await this.uGetRect('#waterfall-left-column-list-10kechengxinxi');
				let rightRect = await this.uGetRect('#waterfall-right-column-list-10kechengxinxi');
				// 如果左边小于或等于右边，就添加到左边，否则添加到右边
				let item = this.tempListList10kechengxinxi[0];
				// 解决多次快速上拉后，可能数据会乱的问题，因为经过上面的两个await节点查询阻塞一定时间，加上后面的定时器干扰
				// 数组可能变成[]，导致此item值可能为undefined
				if (!item) return;
				
				if (leftRect.height < rightRect.height) {
					this.leftListList10kechengxinxi.push(item);
				} else if (leftRect.height > rightRect.height) {
					this.rightListList10kechengxinxi.push(item);
				} else {
					// 这里是为了保证第一和第二张添加时，左右都能有内容
					// 因为添加第一张，实际队列的高度可能还是0，这时需要根据队列元素长度判断下一个该放哪边
					if (this.leftListList10kechengxinxi.length <= this.rightListList10kechengxinxi.length) {
						this.leftListList10kechengxinxi.push(item);
					} else {
						this.rightListList10kechengxinxi.push(item);
					}
				}
				// 移除临时列表的第一项
				this.tempListList10kechengxinxi.splice(0, 1);
				// 如果临时数组还有数据，继续循环
				if (this.tempListList10kechengxinxi.length) {
					setTimeout(()=>{
						this.splitDataList10kechengxinxi();
					}, 150)
					return
				}
			},
			uGetRect(selector, all) {
				return new Promise(resolve => {
					uni.createSelectorQuery()
					.in(this)
					[all ? 'selectAll' : 'select'](selector)
					.boundingClientRect(rect => {
						if (all && Array.isArray(rect) && rect.length) {
							resolve(rect);
						}
						if (!all && rect) {
							resolve(rect);
						}
					})
					.exec();
				});
			},
			cloneData(data) {
				return JSON.parse(JSON.stringify(data));
			},
			newsTabClick2(index){
				this.newsIndex2 = index
				this.getNewsList()
			},
			async getNewsList(){
				let res;
				let params = {
					page: 1,
					limit: 6,
					sort: 'id',
					order: 'desc',
				}
				// 公告信息
				res = await this.$api.list('news', params)
				this.news = res.data.list
			},
			homeTabClick2(index,name){
				this['home' + name + 'Index2'] = index
				this.getHomeList()
			},
			async getHomeList(){
				let res;
				let params;
				params = {
					page:1,
					limit: 6,
				}
				res = await this.$api.list('kechengxinxi', params);
				this.homekechengxinxilist = res.data.list
				this.tempListList10kechengxinxi = this.copyFlowListList10kechengxinxi;
				this.splitDataList10kechengxinxi();
			},
			recommendTabClick2(index,name){
				this[name + 'Index2'] = index
				this.getRecommendList()
			},
			async getRecommendList(){
				let res;
				let params;
			},
			//轮播图跳转
			onSwiperTap(e) {
				if(e.url) {
					if (e.url.indexOf('https') != -1) {
						// #ifdef MP-WEIXIN
						uni.navigateTo({
						    url: '../../common/linkOthers/linkOthers?url=' + encodeURIComponent(e.url),
						});
						return false
						// #endif
						window.open(e.url)
					} else {
						this.$utils.jump(e.url)
					}
				}
			},
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){

				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
            onPageTap2(index) {
				let url = '../' + index + '/list'
				if(index=='forum'){
					url = '../forum-index/forum-index'
				}
                uni.setStorageSync("useridTag",0);
                uni.navigateTo({
                    url: url,
                    fail: function() {
                        uni.switchTab({
                            url: url
                        });
                    }
                });
            }
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}

</style>

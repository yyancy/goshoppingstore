CREATE DATABASE go CHARSET='utf8';
USE goshopping;

/*管理员表 tb_admin*/
CREATE TABLE tb_admin(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(11) NOT NULL,
    pwd  VARCHAR(11) NOT NULL
)charset='utf8';
INSERT INTO tb_admin VALUES(NULL,"张三","123");

/*商品表 tb_goods*/
CREATE TABLE tb_goods(
    id INT PRIMARY KEY AUTO_INCREMENT,
    tid INT NOT NULL,/*分类*/
    NAME VARCHAR(50) NOT NULL,/*商品名称*/
    introduce TEXT,/*描述*/
    price  DECIMAL(10,2) NOT NULL,/*商品正常价格*/
    reducePrice  DECIMAL(10,2) DEFAULT 0 ,
    /*商品降价额度  正常商品是不降价 所以降价额度定为0*/
    photo VARCHAR(50) NOT NULL,/*商品图片*/
    intime DATETIME NOT NULL,/*上架时间*/
    saleNumber INT DEFAULT 0,/*目前销售个数*/
    hit  BOOLEAN  DEFAULT FALSE/*是否已经下架*/
)charset='utf8';


/*订单表 tb_order*/
CREATE TABLE tb_order(
    id INT PRIMARY KEY AUTO_INCREMENT,
    memberId INT NOT NULL,/*会员编号*/
    customName VARCHAR(11) NOT NULL,
    /*收货人名字  不一定和会员名字相同  请理解会员 和  收货人的区别*/
    address  VARCHAR(30) NOT NULL,/*收货人地址*/
    qq     VARCHAR(15) NOT NULL,/*收货人qq*/
    telephone  CHAR(11) NOT NULL,/*收货人电话*/
    payType   VARCHAR(20) NOT NULL,/*付款方式*/
    orderTime  DATETIME NOT NULL,/*客户下订单的时间*/
    state      INT   DEFAULT  1,
    /*
    订单状态   1为客户已经交钱  等待发货
               2为客户已经交钱 已经发货 单没有签收
               3 为客户已经交钱 已经发货 并且已经签收
    */
    bz       VARCHAR(200)    /*订单备注*/
)CHARSET='UTF8';


/*公告表 tb_message*/
CREATE TABLE tb_message(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(30),/*公告题目*/
    content VARCHAR(200) NOT NULL,/*公告内容*/
    inTime DATETIME  /*上架时间*/
)CHARSET='UTF8';


/*会员表 tb_member*/
CREATE TABLE tb_member(
    id INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(11) NOT NULL,   /*昵称*/
    realName VARCHAR(11) NOT NULL,
    pwd   VARCHAR(8) NOT NULL,
    city  VARCHAR(11) NOT NULL,
    address VARCHAR(50) NOT NULL,/*住址  当本会员买东西时  表中的地址可以设置此地址为默认地址*/
    idCard  VARCHAR(20) NOT NULL,/*身份证号*/
    jobType  VARCHAR(20) NOT NULL,/*工作类型*/
    score   INT DEFAULT 100,
    /*总积分  默认是100  只要注册就送100积分  买的东西多积分就会增加
    增加到一定值  根据折扣表tb_rebate 可以获取对应的折扣比例
     如当积分到达10000
     折扣表中 如果有条记录 minscore=10000  rebate=10.0
     那么以后买的所有东西 都是  享受9折 优惠
    */
    qq     VARCHAR(15),/*qq*/
    telephone  CHAR(11) NOT NULL,/*电话*/
    email   VARCHAR(30),  /*邮箱*/
    free     BOOLEAN DEFAULT TRUE/*会员状态  true为激活状态  可以使用 否则不能使用*/
)CHARSET='UTF8';


/*订单详情表 tb_order_detail*/
CREATE TABLE tb_order_detail(
    id INT PRIMARY KEY AUTO_INCREMENT,/*订单详情表编号*/
   orderId INT NOT NULL,/*所属订单编号*/
   goodsId INT NOT NULL,/*商品编号*/
   price DECIMAL(10,2) NOT NULL, /*折扣后的价格*/
   number INT DEFAULT 1/*商品数量*/
)CHARSET='UTF8';


/*折扣表 tb_rebate*/
CREATE TABLE tb_rebate(
    id INT PRIMARY KEY AUTO_INCREMENT,/*折扣id*/
    minScore INT ,           /*折扣每个等级的最低积分*/
    rebate  FLOAT(4,2)
    /*每次付账享受的折扣  百分比
    比如总价格是100元 如果折扣是10.5  实付费用为89.5元*/
)CHARSET='UTF8';

/*子类类型表tb_subtype*/
CREATE TABLE tb_subtype(
    id INT PRIMARY KEY AUTO_INCREMENT,/*小类的id*/
    superType INT NOT NULL,/*所属大类的id*/
    typeName VARCHAR(20) NOT NULL/*小类的名字*/
)CHARSET='UTF8';


/*父类类型表tb_supertype*/
CREATE TABLE tb_supertype(
    id INT PRIMARY KEY AUTO_INCREMENT,/*大类的id*/
    typeName VARCHAR(20) NOT NULL/*大类的名字*/
)CHARSET='UTF8';

INSERT INTO tb_supertype VALUES(NULL,"日用家电");





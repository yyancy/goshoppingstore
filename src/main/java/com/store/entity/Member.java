package com.store.entity;
// id INT PRIMARY KEY AUTO_INCREMENT,
//         NAME VARCHAR(11) NOT NULL,   /*昵称*/
//         realName VARCHAR(11) NOT NULL,
//         pwd   VARCHAR(8) NOT NULL,
//         city  VARCHAR(11) NOT NULL,
//         address VARCHAR(50) NOT NULL,/*住址  当本会员买东西时  表中的地址可以设置此地址为默认地址*/
//         idCard  VARCHAR(20) NOT NULL,/*身份证号*/
//         jobType  VARCHAR(20) NOT NULL,/*工作类型*/
//         score   INT DEFAULT 100,
//    /*总积分  默认是100  只要注册就送100积分  买的东西多积分就会增加
//    增加到一定值  根据折扣表tb_rebate 可以获取对应的折扣比例
//     如当积分到达10000
//     折扣表中 如果有条记录 minscore=10000  rebate=10.0
//     那么以后买的所有东西 都是  享受9折 优惠
//    */
//         qq     VARCHAR(15),/*qq*/
//         telephone  CHAR(11) NOT NULL,/*电话*/
//         email   VARCHAR(30),  /*邮箱*/
//         free     BOOLEAN DEFAULT TRUE/*会员状
public class Member {
    private Integer id;
    private String name;
    private String realName;
    private String pwd;
    private String city;
    private String address;
    private String idCard;
    private String jobType;
    private Integer score;
    private String qq;
    private String telephone;
    private String email;
    private Integer free;





    public String getFields(){
        return "name,realName,pwd,city,address,idCard,jobType,qq,telephone,email";
    }

    public Member( String name, String realName, String pwd, String city,
                   String address, String idCard, String jobType, Integer score) {
        this.name = name;
        this.realName = realName;
        this.pwd = pwd;
        this.city = city;
        this.address = address;
        this.idCard = idCard;
        this.jobType = jobType;
        this.score = score;
    }

    public Member( String name, String realName, String pwd, String city,
                   String address, String idCard, String jobType, String qq,String telephone,String email
    ) {
        this.name = name;
        this.realName = realName;
        this.pwd = pwd;
        this.city = city;
        this.address = address;
        this.idCard = idCard;
        this.jobType = jobType;
        this.qq = qq;
        this.telephone = telephone;
        this.email = email;
    }

    public Member() {
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", realName='" + realName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", idCard='" + idCard + '\'' +
                ", jobType='" + jobType + '\'' +
                ", score=" + score +
                ", qq='" + qq + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", free='" + free + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getFree() {
        return free;
    }

    public void setFree(Integer free) {
        this.free = free;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

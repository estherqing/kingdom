package springTest.basic;

import java.util.List;

/**
 *
 */
public class JsonAutoCreateTest{

    /**
     * projectId : 2000326682
     * name : 陈旭
     * cerType : 1
     * cerNo : 450126199206014912
     * grntBranch : GD
     * areaCode : 440100
     * bankNo : 201002073301
     * custInfo : {"idCard":"450126199206014912","expiryDate":"20180602","licenceIssuingAuthority":"宾阳县公安局","cardOrExpiryDate":false,"hhRegistration":"广西","contact":"13712834703","degree":"2","hcond":"5","hdate":"20030122","homeAdd":"长安镇利商一街一巷31号1008房","tel":"0769-87654321","company":"东莞市三晖塑胶模具有限公司","occupation":"工人","occupationCode":3,"workNatureCode":3,"compTel":"13712834703","compAddress":"长安镇厦边管理区银城一路5号","ed":"20160522","industry":"制造业","monthlyIncome":"3","accFund":"1","homeZipCode":"441901","companyZipCode":"441901","postName":"科员及职员","yearlyIncome":"150000.000000","homeAddpc":"广东省东莞市","companyAddpc":"广东省东莞市","homeAddressPid":"440000","homeSheng":"广东省","homeAddressCid":"441900","homeShi":"东莞市","homeAddressRid":"441901","homeXian":"市辖区","companyAddressPid":"440000","compAddrSheng":"广东省","companyAddressCid":"441900","compAddrShi":"东莞市","companyAddressRid":"441901","compAddrXian":"市辖区","post":4}
     * counterGuarantors : []
     * emContacts : [{"relation":"3","name":"陈宗翔","phone":"13437426088"},{"relation":"9","name":"朱燕涬","phone":"18277191847"}]
     * loan : {"loanNo":"CL601-GD-20181-02033","bizType":"信用卡贷款(普通模式)","businessType":"2","subsidized":"1","carPrice":"125000.00","dp":"46000.00","dpRatio":"32.4800","ins":"36","loan":"79000.0","ifRatio":"9.500000","guarantyFee":"11183.00","bankInstallmentFee":"8567.39","launchDate":"20180122","evaluationPrice":"117000.00","noticeDownpaymentAmount":"2743.29","noticePeriodpaymentAmount":"2743.06","contractDownpaymentAmount":"0.0000","contractPeriodpaymentAmount":"0.0000","noticeDownpaymentAmountSecond":"0","noticePeriodpaymentAmountSecond":"0","contractDownpaymentAmountSecond":"0","contractPeriodpaymentAmountSecond":"0","creditLineAmount":"98750.390000"}
     * car : {"type":"小型轿车","dealer":"东莞市汇得丰二手车交易市场经营管理有限公司","brand":"马自达","model":"马自达","frame":"LVRHDFAL8HN026027","engine":"3355318","capacity":"5","buyDate":"20180129","bill":"01219220","billDate":"20180123","pub":"1","insurance":"0","cu":""}
     * approval : {"approvalDate":"2018-01-25 16:37:56","approvalResult":"同意","approver":"总部审批中心:何顺吉","customerScore":"71.00","scoreLevel":"C","suggestions":[{"suggestion":"总部审批中心:"}]}
     * creditId : 811635
     * hasInterview : 0
     * picmodels : [{"picid":"84","picDirNo":"Z-sfzzm","picurl":"http://zacdn-image.cgw360.com/cgw360/cls/loan/c8b328b8-03ad-4f06-8fc4-55eb89d4e821.png?imageName=01月22日13-36-26_018.png"},{"picid":"89","picDirNo":"Z-srzm","picurl":"http://zacdn-image.cgw360.com/cgw360/cls/loan/97b65cd8-2c19-4b23-a44a-ddcce6877101.png?imageName=01月22日17-03-06_866.png"},{"picid":"88","picDirNo":"Z-hyzkzm","picurl":"http://zacdn-image.cgw360.com/cgw360/cls/loan/e19a204b-2c09-4cbe-ad01-cce73db0e96d.png?imageName=01月22日17-01-51_237.png"}]
     * opr : 1
     */

    private String projectId;
    private String name;
    private String cerType;
    private String cerNo;
    private String grntBranch;
    private String areaCode;
    private String bankNo;
    private CustInfoBean custInfo;
    private LoanBean loan;
    private CarBean car;
    private ApprovalBean approval;
    private String creditId;
    private String hasInterview;
    private String opr;
    private List<?> counterGuarantors;
    private List<EmContactsBean> emContacts;
    private List<PicmodelsBean> picmodels;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCerType() {
        return cerType;
    }

    public void setCerType(String cerType) {
        this.cerType = cerType;
    }

    public String getCerNo() {
        return cerNo;
    }

    public void setCerNo(String cerNo) {
        this.cerNo = cerNo;
    }

    public String getGrntBranch() {
        return grntBranch;
    }

    public void setGrntBranch(String grntBranch) {
        this.grntBranch = grntBranch;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public CustInfoBean getCustInfo() {
        return custInfo;
    }

    public void setCustInfo(CustInfoBean custInfo) {
        this.custInfo = custInfo;
    }

    public LoanBean getLoan() {
        return loan;
    }

    public void setLoan(LoanBean loan) {
        this.loan = loan;
    }

    public CarBean getCar() {
        return car;
    }

    public void setCar(CarBean car) {
        this.car = car;
    }

    public ApprovalBean getApproval() {
        return approval;
    }

    public void setApproval(ApprovalBean approval) {
        this.approval = approval;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getHasInterview() {
        return hasInterview;
    }

    public void setHasInterview(String hasInterview) {
        this.hasInterview = hasInterview;
    }

    public String getOpr() {
        return opr;
    }

    public void setOpr(String opr) {
        this.opr = opr;
    }

    public List<?> getCounterGuarantors() {
        return counterGuarantors;
    }

    public void setCounterGuarantors(List<?> counterGuarantors) {
        this.counterGuarantors = counterGuarantors;
    }

    public List<EmContactsBean> getEmContacts() {
        return emContacts;
    }

    public void setEmContacts(List<EmContactsBean> emContacts) {
        this.emContacts = emContacts;
    }

    public List<PicmodelsBean> getPicmodels() {
        return picmodels;
    }

    public void setPicmodels(List<PicmodelsBean> picmodels) {
        this.picmodels = picmodels;
    }

    public static class CustInfoBean {
        /**
         * idCard : 450126199206014912
         * expiryDate : 20180602
         * licenceIssuingAuthority : 宾阳县公安局
         * cardOrExpiryDate : false
         * hhRegistration : 广西
         * contact : 13712834703
         * degree : 2
         * hcond : 5
         * hdate : 20030122
         * homeAdd : 长安镇利商一街一巷31号1008房
         * tel : 0769-87654321
         * company : 东莞市三晖塑胶模具有限公司
         * occupation : 工人
         * occupationCode : 3
         * workNatureCode : 3
         * compTel : 13712834703
         * compAddress : 长安镇厦边管理区银城一路5号
         * ed : 20160522
         * industry : 制造业
         * monthlyIncome : 3
         * accFund : 1
         * homeZipCode : 441901
         * companyZipCode : 441901
         * postName : 科员及职员
         * yearlyIncome : 150000.000000
         * homeAddpc : 广东省东莞市
         * companyAddpc : 广东省东莞市
         * homeAddressPid : 440000
         * homeSheng : 广东省
         * homeAddressCid : 441900
         * homeShi : 东莞市
         * homeAddressRid : 441901
         * homeXian : 市辖区
         * companyAddressPid : 440000
         * compAddrSheng : 广东省
         * companyAddressCid : 441900
         * compAddrShi : 东莞市
         * companyAddressRid : 441901
         * compAddrXian : 市辖区
         * post : 4
         */

        private String idCard;
        private String expiryDate;
        private String licenceIssuingAuthority;
        private boolean cardOrExpiryDate;
        private String hhRegistration;
        private String contact;
        private String degree;
        private String hcond;
        private String hdate;
        private String homeAdd;
        private String tel;
        private String company;
        private String occupation;
        private int occupationCode;
        private int workNatureCode;
        private String compTel;
        private String compAddress;
        private String ed;
        private String industry;
        private String monthlyIncome;
        private String accFund;
        private String homeZipCode;
        private String companyZipCode;
        private String postName;
        private String yearlyIncome;
        private String homeAddpc;
        private String companyAddpc;
        private String homeAddressPid;
        private String homeSheng;
        private String homeAddressCid;
        private String homeShi;
        private String homeAddressRid;
        private String homeXian;
        private String companyAddressPid;
        private String compAddrSheng;
        private String companyAddressCid;
        private String compAddrShi;
        private String companyAddressRid;
        private String compAddrXian;
        private int post;

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public String getExpiryDate() {
            return expiryDate;
        }

        public void setExpiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
        }

        public String getLicenceIssuingAuthority() {
            return licenceIssuingAuthority;
        }

        public void setLicenceIssuingAuthority(String licenceIssuingAuthority) {
            this.licenceIssuingAuthority = licenceIssuingAuthority;
        }

        public boolean isCardOrExpiryDate() {
            return cardOrExpiryDate;
        }

        public void setCardOrExpiryDate(boolean cardOrExpiryDate) {
            this.cardOrExpiryDate = cardOrExpiryDate;
        }

        public String getHhRegistration() {
            return hhRegistration;
        }

        public void setHhRegistration(String hhRegistration) {
            this.hhRegistration = hhRegistration;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getDegree() {
            return degree;
        }

        public void setDegree(String degree) {
            this.degree = degree;
        }

        public String getHcond() {
            return hcond;
        }

        public void setHcond(String hcond) {
            this.hcond = hcond;
        }

        public String getHdate() {
            return hdate;
        }

        public void setHdate(String hdate) {
            this.hdate = hdate;
        }

        public String getHomeAdd() {
            return homeAdd;
        }

        public void setHomeAdd(String homeAdd) {
            this.homeAdd = homeAdd;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getOccupation() {
            return occupation;
        }

        public void setOccupation(String occupation) {
            this.occupation = occupation;
        }

        public int getOccupationCode() {
            return occupationCode;
        }

        public void setOccupationCode(int occupationCode) {
            this.occupationCode = occupationCode;
        }

        public int getWorkNatureCode() {
            return workNatureCode;
        }

        public void setWorkNatureCode(int workNatureCode) {
            this.workNatureCode = workNatureCode;
        }

        public String getCompTel() {
            return compTel;
        }

        public void setCompTel(String compTel) {
            this.compTel = compTel;
        }

        public String getCompAddress() {
            return compAddress;
        }

        public void setCompAddress(String compAddress) {
            this.compAddress = compAddress;
        }

        public String getEd() {
            return ed;
        }

        public void setEd(String ed) {
            this.ed = ed;
        }

        public String getIndustry() {
            return industry;
        }

        public void setIndustry(String industry) {
            this.industry = industry;
        }

        public String getMonthlyIncome() {
            return monthlyIncome;
        }

        public void setMonthlyIncome(String monthlyIncome) {
            this.monthlyIncome = monthlyIncome;
        }

        public String getAccFund() {
            return accFund;
        }

        public void setAccFund(String accFund) {
            this.accFund = accFund;
        }

        public String getHomeZipCode() {
            return homeZipCode;
        }

        public void setHomeZipCode(String homeZipCode) {
            this.homeZipCode = homeZipCode;
        }

        public String getCompanyZipCode() {
            return companyZipCode;
        }

        public void setCompanyZipCode(String companyZipCode) {
            this.companyZipCode = companyZipCode;
        }

        public String getPostName() {
            return postName;
        }

        public void setPostName(String postName) {
            this.postName = postName;
        }

        public String getYearlyIncome() {
            return yearlyIncome;
        }

        public void setYearlyIncome(String yearlyIncome) {
            this.yearlyIncome = yearlyIncome;
        }

        public String getHomeAddpc() {
            return homeAddpc;
        }

        public void setHomeAddpc(String homeAddpc) {
            this.homeAddpc = homeAddpc;
        }

        public String getCompanyAddpc() {
            return companyAddpc;
        }

        public void setCompanyAddpc(String companyAddpc) {
            this.companyAddpc = companyAddpc;
        }

        public String getHomeAddressPid() {
            return homeAddressPid;
        }

        public void setHomeAddressPid(String homeAddressPid) {
            this.homeAddressPid = homeAddressPid;
        }

        public String getHomeSheng() {
            return homeSheng;
        }

        public void setHomeSheng(String homeSheng) {
            this.homeSheng = homeSheng;
        }

        public String getHomeAddressCid() {
            return homeAddressCid;
        }

        public void setHomeAddressCid(String homeAddressCid) {
            this.homeAddressCid = homeAddressCid;
        }

        public String getHomeShi() {
            return homeShi;
        }

        public void setHomeShi(String homeShi) {
            this.homeShi = homeShi;
        }

        public String getHomeAddressRid() {
            return homeAddressRid;
        }

        public void setHomeAddressRid(String homeAddressRid) {
            this.homeAddressRid = homeAddressRid;
        }

        public String getHomeXian() {
            return homeXian;
        }

        public void setHomeXian(String homeXian) {
            this.homeXian = homeXian;
        }

        public String getCompanyAddressPid() {
            return companyAddressPid;
        }

        public void setCompanyAddressPid(String companyAddressPid) {
            this.companyAddressPid = companyAddressPid;
        }

        public String getCompAddrSheng() {
            return compAddrSheng;
        }

        public void setCompAddrSheng(String compAddrSheng) {
            this.compAddrSheng = compAddrSheng;
        }

        public String getCompanyAddressCid() {
            return companyAddressCid;
        }

        public void setCompanyAddressCid(String companyAddressCid) {
            this.companyAddressCid = companyAddressCid;
        }

        public String getCompAddrShi() {
            return compAddrShi;
        }

        public void setCompAddrShi(String compAddrShi) {
            this.compAddrShi = compAddrShi;
        }

        public String getCompanyAddressRid() {
            return companyAddressRid;
        }

        public void setCompanyAddressRid(String companyAddressRid) {
            this.companyAddressRid = companyAddressRid;
        }

        public String getCompAddrXian() {
            return compAddrXian;
        }

        public void setCompAddrXian(String compAddrXian) {
            this.compAddrXian = compAddrXian;
        }

        public int getPost() {
            return post;
        }

        public void setPost(int post) {
            this.post = post;
        }
    }

    public static class LoanBean {
        /**
         * loanNo : CL601-GD-20181-02033
         * bizType : 信用卡贷款(普通模式)
         * businessType : 2
         * subsidized : 1
         * carPrice : 125000.00
         * dp : 46000.00
         * dpRatio : 32.4800
         * ins : 36
         * loan : 79000.0
         * ifRatio : 9.500000
         * guarantyFee : 11183.00
         * bankInstallmentFee : 8567.39
         * launchDate : 20180122
         * evaluationPrice : 117000.00
         * noticeDownpaymentAmount : 2743.29
         * noticePeriodpaymentAmount : 2743.06
         * contractDownpaymentAmount : 0.0000
         * contractPeriodpaymentAmount : 0.0000
         * noticeDownpaymentAmountSecond : 0
         * noticePeriodpaymentAmountSecond : 0
         * contractDownpaymentAmountSecond : 0
         * contractPeriodpaymentAmountSecond : 0
         * creditLineAmount : 98750.390000
         */

        private String loanNo;
        private String bizType;
        private String businessType;
        private String subsidized;
        private String carPrice;
        private String dp;
        private String dpRatio;
        private String ins;
        private String loan;
        private String ifRatio;
        private String guarantyFee;
        private String bankInstallmentFee;
        private String launchDate;
        private String evaluationPrice;
        private String noticeDownpaymentAmount;
        private String noticePeriodpaymentAmount;
        private String contractDownpaymentAmount;
        private String contractPeriodpaymentAmount;
        private String noticeDownpaymentAmountSecond;
        private String noticePeriodpaymentAmountSecond;
        private String contractDownpaymentAmountSecond;
        private String contractPeriodpaymentAmountSecond;
        private String creditLineAmount;

        public String getLoanNo() {
            return loanNo;
        }

        public void setLoanNo(String loanNo) {
            this.loanNo = loanNo;
        }

        public String getBizType() {
            return bizType;
        }

        public void setBizType(String bizType) {
            this.bizType = bizType;
        }

        public String getBusinessType() {
            return businessType;
        }

        public void setBusinessType(String businessType) {
            this.businessType = businessType;
        }

        public String getSubsidized() {
            return subsidized;
        }

        public void setSubsidized(String subsidized) {
            this.subsidized = subsidized;
        }

        public String getCarPrice() {
            return carPrice;
        }

        public void setCarPrice(String carPrice) {
            this.carPrice = carPrice;
        }

        public String getDp() {
            return dp;
        }

        public void setDp(String dp) {
            this.dp = dp;
        }

        public String getDpRatio() {
            return dpRatio;
        }

        public void setDpRatio(String dpRatio) {
            this.dpRatio = dpRatio;
        }

        public String getIns() {
            return ins;
        }

        public void setIns(String ins) {
            this.ins = ins;
        }

        public String getLoan() {
            return loan;
        }

        public void setLoan(String loan) {
            this.loan = loan;
        }

        public String getIfRatio() {
            return ifRatio;
        }

        public void setIfRatio(String ifRatio) {
            this.ifRatio = ifRatio;
        }

        public String getGuarantyFee() {
            return guarantyFee;
        }

        public void setGuarantyFee(String guarantyFee) {
            this.guarantyFee = guarantyFee;
        }

        public String getBankInstallmentFee() {
            return bankInstallmentFee;
        }

        public void setBankInstallmentFee(String bankInstallmentFee) {
            this.bankInstallmentFee = bankInstallmentFee;
        }

        public String getLaunchDate() {
            return launchDate;
        }

        public void setLaunchDate(String launchDate) {
            this.launchDate = launchDate;
        }

        public String getEvaluationPrice() {
            return evaluationPrice;
        }

        public void setEvaluationPrice(String evaluationPrice) {
            this.evaluationPrice = evaluationPrice;
        }

        public String getNoticeDownpaymentAmount() {
            return noticeDownpaymentAmount;
        }

        public void setNoticeDownpaymentAmount(String noticeDownpaymentAmount) {
            this.noticeDownpaymentAmount = noticeDownpaymentAmount;
        }

        public String getNoticePeriodpaymentAmount() {
            return noticePeriodpaymentAmount;
        }

        public void setNoticePeriodpaymentAmount(String noticePeriodpaymentAmount) {
            this.noticePeriodpaymentAmount = noticePeriodpaymentAmount;
        }

        public String getContractDownpaymentAmount() {
            return contractDownpaymentAmount;
        }

        public void setContractDownpaymentAmount(String contractDownpaymentAmount) {
            this.contractDownpaymentAmount = contractDownpaymentAmount;
        }

        public String getContractPeriodpaymentAmount() {
            return contractPeriodpaymentAmount;
        }

        public void setContractPeriodpaymentAmount(String contractPeriodpaymentAmount) {
            this.contractPeriodpaymentAmount = contractPeriodpaymentAmount;
        }

        public String getNoticeDownpaymentAmountSecond() {
            return noticeDownpaymentAmountSecond;
        }

        public void setNoticeDownpaymentAmountSecond(String noticeDownpaymentAmountSecond) {
            this.noticeDownpaymentAmountSecond = noticeDownpaymentAmountSecond;
        }

        public String getNoticePeriodpaymentAmountSecond() {
            return noticePeriodpaymentAmountSecond;
        }

        public void setNoticePeriodpaymentAmountSecond(String noticePeriodpaymentAmountSecond) {
            this.noticePeriodpaymentAmountSecond = noticePeriodpaymentAmountSecond;
        }

        public String getContractDownpaymentAmountSecond() {
            return contractDownpaymentAmountSecond;
        }

        public void setContractDownpaymentAmountSecond(String contractDownpaymentAmountSecond) {
            this.contractDownpaymentAmountSecond = contractDownpaymentAmountSecond;
        }

        public String getContractPeriodpaymentAmountSecond() {
            return contractPeriodpaymentAmountSecond;
        }

        public void setContractPeriodpaymentAmountSecond(String contractPeriodpaymentAmountSecond) {
            this.contractPeriodpaymentAmountSecond = contractPeriodpaymentAmountSecond;
        }

        public String getCreditLineAmount() {
            return creditLineAmount;
        }

        public void setCreditLineAmount(String creditLineAmount) {
            this.creditLineAmount = creditLineAmount;
        }
    }

    public static class CarBean {
        /**
         * type : 小型轿车
         * dealer : 东莞市汇得丰二手车交易市场经营管理有限公司
         * brand : 马自达
         * model : 马自达
         * frame : LVRHDFAL8HN026027
         * engine : 3355318
         * capacity : 5
         * buyDate : 20180129
         * bill : 01219220
         * billDate : 20180123
         * pub : 1
         * insurance : 0
         * cu :
         */

        private String type;
        private String dealer;
        private String brand;
        private String model;
        private String frame;
        private String engine;
        private String capacity;
        private String buyDate;
        private String bill;
        private String billDate;
        private String pub;
        private String insurance;
        private String cu;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDealer() {
            return dealer;
        }

        public void setDealer(String dealer) {
            this.dealer = dealer;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getFrame() {
            return frame;
        }

        public void setFrame(String frame) {
            this.frame = frame;
        }

        public String getEngine() {
            return engine;
        }

        public void setEngine(String engine) {
            this.engine = engine;
        }

        public String getCapacity() {
            return capacity;
        }

        public void setCapacity(String capacity) {
            this.capacity = capacity;
        }

        public String getBuyDate() {
            return buyDate;
        }

        public void setBuyDate(String buyDate) {
            this.buyDate = buyDate;
        }

        public String getBill() {
            return bill;
        }

        public void setBill(String bill) {
            this.bill = bill;
        }

        public String getBillDate() {
            return billDate;
        }

        public void setBillDate(String billDate) {
            this.billDate = billDate;
        }

        public String getPub() {
            return pub;
        }

        public void setPub(String pub) {
            this.pub = pub;
        }

        public String getInsurance() {
            return insurance;
        }

        public void setInsurance(String insurance) {
            this.insurance = insurance;
        }

        public String getCu() {
            return cu;
        }

        public void setCu(String cu) {
            this.cu = cu;
        }
    }

    public static class ApprovalBean {
        /**
         * approvalDate : 2018-01-25 16:37:56
         * approvalResult : 同意
         * approver : 总部审批中心:何顺吉
         * customerScore : 71.00
         * scoreLevel : C
         * suggestions : [{"suggestion":"总部审批中心:"}]
         */

        private String approvalDate;
        private String approvalResult;
        private String approver;
        private String customerScore;
        private String scoreLevel;
        private List<SuggestionsBean> suggestions;

        public String getApprovalDate() {
            return approvalDate;
        }

        public void setApprovalDate(String approvalDate) {
            this.approvalDate = approvalDate;
        }

        public String getApprovalResult() {
            return approvalResult;
        }

        public void setApprovalResult(String approvalResult) {
            this.approvalResult = approvalResult;
        }

        public String getApprover() {
            return approver;
        }

        public void setApprover(String approver) {
            this.approver = approver;
        }

        public String getCustomerScore() {
            return customerScore;
        }

        public void setCustomerScore(String customerScore) {
            this.customerScore = customerScore;
        }

        public String getScoreLevel() {
            return scoreLevel;
        }

        public void setScoreLevel(String scoreLevel) {
            this.scoreLevel = scoreLevel;
        }

        public List<SuggestionsBean> getSuggestions() {
            return suggestions;
        }

        public void setSuggestions(List<SuggestionsBean> suggestions) {
            this.suggestions = suggestions;
        }

        public static class SuggestionsBean {
            /**
             * suggestion : 总部审批中心:
             */

            private String suggestion;

            public String getSuggestion() {
                return suggestion;
            }

            public void setSuggestion(String suggestion) {
                this.suggestion = suggestion;
            }
        }
    }

    public static class EmContactsBean {
        /**
         * relation : 3
         * name : 陈宗翔
         * phone : 13437426088
         */

        private String relation;
        private String name;
        private String phone;

        public String getRelation() {
            return relation;
        }

        public void setRelation(String relation) {
            this.relation = relation;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    public static class PicmodelsBean {
        /**
         * picid : 84
         * picDirNo : Z-sfzzm
         * picurl : http://zacdn-image.cgw360.com/cgw360/cls/loan/c8b328b8-03ad-4f06-8fc4-55eb89d4e821.png?imageName=01月22日13-36-26_018.png
         */

        private String picid;
        private String picDirNo;
        private String picurl;

        public String getPicid() {
            return picid;
        }

        public void setPicid(String picid) {
            this.picid = picid;
        }

        public String getPicDirNo() {
            return picDirNo;
        }

        public void setPicDirNo(String picDirNo) {
            this.picDirNo = picDirNo;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }
    }

    @Override
    public String toString() {
        return "JsonAutoCreateTest{" +
                "projectId='" + projectId + '\'' +
                ", name='" + name + '\'' +
                ", cerType='" + cerType + '\'' +
                ", cerNo='" + cerNo + '\'' +
                ", grntBranch='" + grntBranch + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", bankNo='" + bankNo + '\'' +
                ", custInfo=" + custInfo +
                ", loan=" + loan +
                ", car=" + car +
                ", approval=" + approval +
                ", creditId='" + creditId + '\'' +
                ", hasInterview='" + hasInterview + '\'' +
                ", opr='" + opr + '\'' +
                ", counterGuarantors=" + counterGuarantors +
                ", emContacts=" + emContacts +
                ", picmodels=" + picmodels +
                '}';
    }
}
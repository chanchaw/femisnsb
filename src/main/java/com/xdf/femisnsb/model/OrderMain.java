package com.xdf.femisnsb.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderMain {

	private int id;
	private String codeid;
    private Date billdate;
    private Date deliverytime;
    private String clientid;
    private String pactcode;
    private String deliverytype;
    private int invoice;
    private String operator;
    private String salesman;
    private String companytitle;
    private String remark;
    private int status;
    private Date updatedate;
    private String updateuser;
    private String billtype;
    private String packmanner;
    private Date createdate;
    private Date createtime;
    private String creator;
    private float pactsum;
    private String settlement;
    private String salecategory;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodeid() {
		return codeid;
	}
	public void setCodeid(String codeid) {
		this.codeid = codeid;
	}
	public Date getBilldate() {
		return billdate;
	}
	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}
	public Date getDeliverytime() {
		return deliverytime;
	}
	public void setDeliverytime(Date deliverytime) {
		this.deliverytime = deliverytime;
	}
	public String getClientid() {
		return clientid;
	}
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}
	public String getPactcode() {
		return pactcode;
	}
	public void setPactcode(String pactcode) {
		this.pactcode = pactcode;
	}
	public String getDeliverytype() {
		return deliverytype;
	}
	public void setDeliverytype(String deliverytype) {
		this.deliverytype = deliverytype;
	}
	public int getInvoice() {
		return invoice;
	}
	public void setInvoice(int invoice) {
		this.invoice = invoice;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getSalesman() {
		return salesman;
	}
	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}
	public String getCompanytitle() {
		return companytitle;
	}
	public void setCompanytitle(String companytitle) {
		this.companytitle = companytitle;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public String getUpdateuser() {
		return updateuser;
	}
	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}
	public String getBilltype() {
		return billtype;
	}
	public void setBilltype(String billtype) {
		this.billtype = billtype;
	}
	public String getPackmanner() {
		return packmanner;
	}
	public void setPackmanner(String packmanner) {
		this.packmanner = packmanner;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public float getPactsum() {
		return pactsum;
	}
	public void setPactsum(float pactsum) {
		this.pactsum = pactsum;
	}
	public String getSettlement() {
		return settlement;
	}
	public void setSettlement(String settlement) {
		this.settlement = settlement;
	}
	public String getSalecategory() {
		return salecategory;
	}
	public void setSalecategory(String salecategory) {
		this.salecategory = salecategory;
	}
	@Override
	public String toString() {
		return "OrderMain [id=" + id + ", codeid=" + codeid + ", billdate=" + billdate + ", deliverytime="
				+ deliverytime + ", clientid=" + clientid + ", pactcode=" + pactcode + ", deliverytype=" + deliverytype
				+ ", invoice=" + invoice + ", operator=" + operator + ", salesman=" + salesman + ", companytitle="
				+ companytitle + ", remark=" + remark + ", status=" + status + ", updatedate=" + updatedate
				+ ", updateuser=" + updateuser + ", billtype=" + billtype + ", packmanner=" + packmanner
				+ ", createdate=" + createdate + ", createtime=" + createtime + ", creator=" + creator + ", pactsum="
				+ pactsum + ", settlement=" + settlement + ", salecategory=" + salecategory + "]";
	}
    
    
}
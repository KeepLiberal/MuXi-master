package com.muxi.investment.domain;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.muxi.common.annotation.Excel;
import com.muxi.common.core.domain.BaseEntity;

/**
 * 公司基本信息对象 inv_company
 *
 * @author wenyong.yang
 * @date 2022-05-03
 */
public class InvCompany extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 股票代码
     */
    @Excel(name = "股票代码")
    private String code;

    /**
     * 公司名称
     */
    @Excel(name = "公司名称")
    private String gsmc;

    /**
     * 英文名称
     */
    @Excel(name = "英文名称")
    private String ywmc;

    /**
     * 曾用名
     */
    @Excel(name = "曾用名")
    private String cym;

    /**
     * A股代码
     */
    @Excel(name = "A股代码")
    private String agdm;

    /**
     * A股简称
     */
    @Excel(name = "A股简称")
    private String agjc;

    /**
     * B股代码
     */
    @Excel(name = "B股代码")
    private String bgdm;

    /**
     * B股简称
     */
    @Excel(name = "B股简称")
    private String bgjc;

    /**
     * H股代码
     */
    @Excel(name = "H股代码")
    private String hgdm;

    /**
     * H股简称
     */
    @Excel(name = "H股简称")
    private String hgjc;

    /**
     * 证券类别
     */
    @Excel(name = "证券类别")
    private String zqlb;

    /**
     * 所属东财行业
     */
    @Excel(name = "所属东财行业")
    private String sshy;

    /**
     * 上市交易所
     */
    @Excel(name = "上市交易所")
    private String ssjys;

    /**
     * 所属证监会行业
     */
    @Excel(name = "所属证监会行业")
    private String sszjhhy;

    /**
     * 总经理
     */
    @Excel(name = "总经理")
    private String zjl;

    /**
     * 法人代表
     */
    @Excel(name = "法人代表")
    private String frdb;

    /**
     * 董秘
     */
    @Excel(name = "董秘")
    private String dm;

    /**
     * 董事长
     */
    @Excel(name = "董事长")
    private String dsz;

    /**
     * 证券事务代表
     */
    @Excel(name = "证券事务代表")
    private String zqswdb;

    /**
     * 独立董事
     */
    @Excel(name = "独立董事")
    private String dlds;

    /**
     * 联系电话
     */
    @Excel(name = "联系电话")
    private String lxdh;

    /**
     * 电子信箱
     */
    @Excel(name = "电子信箱")
    private String dzxx;

    /**
     * 传真
     */
    @Excel(name = "传真")
    private String cz;

    /**
     * 公司网址
     */
    @Excel(name = "公司网址")
    private String gswz;

    /**
     * 办公地址
     */
    @Excel(name = "办公地址")
    private String bgdz;

    /**
     * 注册地址
     */
    @Excel(name = "注册地址")
    private String zcdz;

    /**
     * 区域
     */
    @Excel(name = "区域")
    private String qy;

    /**
     * 邮政编码
     */
    @Excel(name = "邮政编码")
    private String yzbm;

    /**
     * 注册资本(元)
     */
    @Excel(name = "注册资本(元)")
    private Double zczb;

    /**
     * 工商登记
     */
    @Excel(name = "工商登记")
    private String gsdj;

    /**
     * 雇员人数
     */
    @Excel(name = "雇员人数")
    private Integer gyrs;

    /**
     * 管理人员人数
     */
    @Excel(name = "管理人员人数")
    private Integer glryrs;

    /**
     * 律师事务所
     */
    @Excel(name = "律师事务所")
    private String lssws;

    /**
     * 会计师事务所
     */
    @Excel(name = "会计师事务所")
    private String kjssws;

    /**
     * 公司简介
     */
    @Excel(name = "公司简介")
    private String gsjj;

    /**
     * 经营范围
     */
    @Excel(name = "经营范围")
    private String jyfw;

    /**
     * 成立日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成立日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date clrq;

    /**
     * 上市日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上市日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date ssrq;

    /**
     * 网上发行日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "网上发行日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date wsfxrq;

    /**
     * 发行方式
     */
    @Excel(name = "发行方式")
    private String fxfs;

    /**
     * 发行市盈率(倍)
     */
    @Excel(name = "发行市盈率(倍)")
    private Double fxsyl;

    /**
     * 发行量(股)
     */
    @Excel(name = "发行量(股)")
    private Integer fxl;

    /**
     * 每股面值(元)
     */
    @Excel(name = "每股面值(元)")
    private Double mgmz;

    /**
     * 每股发行价(元)
     */
    @Excel(name = "每股发行价(元)")
    private Double mgfxj;

    /**
     * 发行费用(元)
     */
    @Excel(name = "发行费用(元)")
    private Double fxfy;

    /**
     * 发行总市值(元)
     */
    @Excel(name = "发行总市值(元)")
    private Double fxzsz;

    /**
     * 募集资金净额(元)
     */
    @Excel(name = "募集资金净额(元)")
    private Double mjzjje;

    /**
     * 首日开盘价(元)
     */
    @Excel(name = "首日开盘价(元)")
    private Double srkpj;

    /**
     * 首日收盘价(元)
     */
    @Excel(name = "首日收盘价(元)")
    private Double srspj;

    /**
     * 首日换手率
     */
    @Excel(name = "首日换手率")
    private Double srhsl;

    /**
     * 首日最高价(元)
     */
    @Excel(name = "首日最高价(元)")
    private Double srzgj;

    /**
     * 网下配售中签率%
     */
    @Excel(name = "网下配售中签率%")
    private Double wxpszql;

    /**
     * 定价中签率%
     */
    @Excel(name = "定价中签率%")
    private Double djzql;


    public InvCompany(String code) {
        this.code = code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setGsmc(String gsmc) {
        this.gsmc = gsmc;
    }

    public String getGsmc() {
        return gsmc;
    }

    public void setYwmc(String ywmc) {
        this.ywmc = ywmc;
    }

    public String getYwmc() {
        return ywmc;
    }

    public void setCym(String cym) {
        this.cym = cym;
    }

    public String getCym() {
        return cym;
    }

    public void setAgdm(String agdm) {
        this.agdm = agdm;
    }

    public String getAgdm() {
        return agdm;
    }

    public void setAgjc(String agjc) {
        this.agjc = agjc;
    }

    public String getAgjc() {
        return agjc;
    }

    public void setBgdm(String bgdm) {
        this.bgdm = bgdm;
    }

    public String getBgdm() {
        return bgdm;
    }

    public void setBgjc(String bgjc) {
        this.bgjc = bgjc;
    }

    public String getBgjc() {
        return bgjc;
    }

    public void setHgdm(String hgdm) {
        this.hgdm = hgdm;
    }

    public String getHgdm() {
        return hgdm;
    }

    public void setHgjc(String hgjc) {
        this.hgjc = hgjc;
    }

    public String getHgjc() {
        return hgjc;
    }

    public void setZqlb(String zqlb) {
        this.zqlb = zqlb;
    }

    public String getZqlb() {
        return zqlb;
    }

    public void setSshy(String sshy) {
        this.sshy = sshy;
    }

    public String getSshy() {
        return sshy;
    }

    public void setSsjys(String ssjys) {
        this.ssjys = ssjys;
    }

    public String getSsjys() {
        return ssjys;
    }

    public void setSszjhhy(String sszjhhy) {
        this.sszjhhy = sszjhhy;
    }

    public String getSszjhhy() {
        return sszjhhy;
    }

    public void setZjl(String zjl) {
        this.zjl = zjl;
    }

    public String getZjl() {
        return zjl;
    }

    public void setFrdb(String frdb) {
        this.frdb = frdb;
    }

    public String getFrdb() {
        return frdb;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    public String getDm() {
        return dm;
    }

    public void setDsz(String dsz) {
        this.dsz = dsz;
    }

    public String getDsz() {
        return dsz;
    }

    public void setZqswdb(String zqswdb) {
        this.zqswdb = zqswdb;
    }

    public String getZqswdb() {
        return zqswdb;
    }

    public void setDlds(String dlds) {
        this.dlds = dlds;
    }

    public String getDlds() {
        return dlds;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setDzxx(String dzxx) {
        this.dzxx = dzxx;
    }

    public String getDzxx() {
        return dzxx;
    }

    public void setCz(String cz) {
        this.cz = cz;
    }

    public String getCz() {
        return cz;
    }

    public void setGswz(String gswz) {
        this.gswz = gswz;
    }

    public String getGswz() {
        return gswz;
    }

    public void setBgdz(String bgdz) {
        this.bgdz = bgdz;
    }

    public String getBgdz() {
        return bgdz;
    }

    public void setZcdz(String zcdz) {
        this.zcdz = zcdz;
    }

    public String getZcdz() {
        return zcdz;
    }

    public void setQy(String qy) {
        this.qy = qy;
    }

    public String getQy() {
        return qy;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    public String getYzbm() {
        return yzbm;
    }

    public void setZczb(Double zczb) {
        this.zczb = zczb;
    }

    public Double getZczb() {
        return zczb;
    }

    public void setGsdj(String gsdj) {
        this.gsdj = gsdj;
    }

    public String getGsdj() {
        return gsdj;
    }

    public void setGyrs(Integer gyrs) {
        this.gyrs = gyrs;
    }

    public Integer getGyrs() {
        return gyrs;
    }

    public void setGlryrs(Integer glryrs) {
        this.glryrs = glryrs;
    }

    public Integer getGlryrs() {
        return glryrs;
    }

    public void setLssws(String lssws) {
        this.lssws = lssws;
    }

    public String getLssws() {
        return lssws;
    }

    public void setKjssws(String kjssws) {
        this.kjssws = kjssws;
    }

    public String getKjssws() {
        return kjssws;
    }

    public void setGsjj(String gsjj) {
        this.gsjj = gsjj;
    }

    public String getGsjj() {
        return gsjj;
    }

    public void setJyfw(String jyfw) {
        this.jyfw = jyfw;
    }

    public String getJyfw() {
        return jyfw;
    }

    public void setClrq(Date clrq) {
        this.clrq = clrq;
    }

    public Date getClrq() {
        return clrq;
    }

    public void setSsrq(Date ssrq) {
        this.ssrq = ssrq;
    }

    public Date getSsrq() {
        return ssrq;
    }

    public void setWsfxrq(Date wsfxrq) {
        this.wsfxrq = wsfxrq;
    }

    public Date getWsfxrq() {
        return wsfxrq;
    }

    public void setFxfs(String fxfs) {
        this.fxfs = fxfs;
    }

    public String getFxfs() {
        return fxfs;
    }

    public void setFxsyl(Double fxsyl) {
        this.fxsyl = fxsyl;
    }

    public Double getFxsyl() {
        return fxsyl;
    }

    public void setFxl(Integer fxl) {
        this.fxl = fxl;
    }

    public Integer getFxl() {
        return fxl;
    }

    public void setMgmz(Double mgmz) {
        this.mgmz = mgmz;
    }

    public Double getMgmz() {
        return mgmz;
    }

    public void setMgfxj(Double mgfxj) {
        this.mgfxj = mgfxj;
    }

    public Double getMgfxj() {
        return mgfxj;
    }

    public void setFxfy(Double fxfy) {
        this.fxfy = fxfy;
    }

    public Double getFxfy() {
        return fxfy;
    }

    public void setFxzsz(Double fxzsz) {
        this.fxzsz = fxzsz;
    }

    public Double getFxzsz() {
        return fxzsz;
    }

    public void setMjzjje(Double mjzjje) {
        this.mjzjje = mjzjje;
    }

    public Double getMjzjje() {
        return mjzjje;
    }

    public void setSrkpj(Double srkpj) {
        this.srkpj = srkpj;
    }

    public Double getSrkpj() {
        return srkpj;
    }

    public void setSrspj(Double srspj) {
        this.srspj = srspj;
    }

    public Double getSrspj() {
        return srspj;
    }

    public void setSrhsl(Double srhsl) {
        this.srhsl = srhsl;
    }

    public Double getSrhsl() {
        return srhsl;
    }

    public void setSrzgj(Double srzgj) {
        this.srzgj = srzgj;
    }

    public Double getSrzgj() {
        return srzgj;
    }

    public void setWxpszql(Double wxpszql) {
        this.wxpszql = wxpszql;
    }

    public Double getWxpszql() {
        return wxpszql;
    }

    public void setDjzql(Double djzql) {
        this.djzql = djzql;
    }

    public Double getDjzql() {
        return djzql;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("code", getCode())
                .append("gsmc", getGsmc())
                .append("ywmc", getYwmc())
                .append("cym", getCym())
                .append("agdm", getAgdm())
                .append("agjc", getAgjc())
                .append("bgdm", getBgdm())
                .append("bgjc", getBgjc())
                .append("hgdm", getHgdm())
                .append("hgjc", getHgjc())
                .append("zqlb", getZqlb())
                .append("sshy", getSshy())
                .append("ssjys", getSsjys())
                .append("sszjhhy", getSszjhhy())
                .append("zjl", getZjl())
                .append("frdb", getFrdb())
                .append("dm", getDm())
                .append("dsz", getDsz())
                .append("zqswdb", getZqswdb())
                .append("dlds", getDlds())
                .append("lxdh", getLxdh())
                .append("dzxx", getDzxx())
                .append("cz", getCz())
                .append("gswz", getGswz())
                .append("bgdz", getBgdz())
                .append("zcdz", getZcdz())
                .append("qy", getQy())
                .append("yzbm", getYzbm())
                .append("zczb", getZczb())
                .append("gsdj", getGsdj())
                .append("gyrs", getGyrs())
                .append("glryrs", getGlryrs())
                .append("lssws", getLssws())
                .append("kjssws", getKjssws())
                .append("gsjj", getGsjj())
                .append("jyfw", getJyfw())
                .append("clrq", getClrq())
                .append("ssrq", getSsrq())
                .append("wsfxrq", getWsfxrq())
                .append("fxfs", getFxfs())
                .append("fxsyl", getFxsyl())
                .append("fxl", getFxl())
                .append("mgmz", getMgmz())
                .append("mgfxj", getMgfxj())
                .append("fxfy", getFxfy())
                .append("fxzsz", getFxzsz())
                .append("mjzjje", getMjzjje())
                .append("srkpj", getSrkpj())
                .append("srspj", getSrspj())
                .append("srhsl", getSrhsl())
                .append("srzgj", getSrzgj())
                .append("wxpszql", getWxpszql())
                .append("djzql", getDjzql())
                .toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvCompany)) return false;
        InvCompany that = (InvCompany) o;
        return Objects.equals(code, that.code) && Objects.equals(gsmc, that.gsmc) && Objects.equals(ywmc, that.ywmc) && Objects.equals(cym, that.cym) && Objects.equals(agdm, that.agdm) && Objects.equals(agjc, that.agjc) && Objects.equals(bgdm, that.bgdm) && Objects.equals(bgjc, that.bgjc) && Objects.equals(hgdm, that.hgdm) && Objects.equals(hgjc, that.hgjc) && Objects.equals(zqlb, that.zqlb) && Objects.equals(sshy, that.sshy) && Objects.equals(ssjys, that.ssjys) && Objects.equals(sszjhhy, that.sszjhhy) && Objects.equals(zjl, that.zjl) && Objects.equals(frdb, that.frdb) && Objects.equals(dm, that.dm) && Objects.equals(dsz, that.dsz) && Objects.equals(zqswdb, that.zqswdb) && Objects.equals(dlds, that.dlds) && Objects.equals(lxdh, that.lxdh) && Objects.equals(dzxx, that.dzxx) && Objects.equals(cz, that.cz) && Objects.equals(gswz, that.gswz) && Objects.equals(bgdz, that.bgdz) && Objects.equals(zcdz, that.zcdz) && Objects.equals(qy, that.qy) && Objects.equals(yzbm, that.yzbm) && Objects.equals(zczb, that.zczb) && Objects.equals(gsdj, that.gsdj) && Objects.equals(gyrs, that.gyrs) && Objects.equals(glryrs, that.glryrs) && Objects.equals(lssws, that.lssws) && Objects.equals(kjssws, that.kjssws) && Objects.equals(gsjj, that.gsjj) && Objects.equals(jyfw, that.jyfw) && Objects.equals(clrq, that.clrq) && Objects.equals(ssrq, that.ssrq) && Objects.equals(wsfxrq, that.wsfxrq) && Objects.equals(fxfs, that.fxfs) && Objects.equals(fxsyl, that.fxsyl) && Objects.equals(fxl, that.fxl) && Objects.equals(mgmz, that.mgmz) && Objects.equals(mgfxj, that.mgfxj) && Objects.equals(fxfy, that.fxfy) && Objects.equals(fxzsz, that.fxzsz) && Objects.equals(mjzjje, that.mjzjje) && Objects.equals(srkpj, that.srkpj) && Objects.equals(srspj, that.srspj) && Objects.equals(srhsl, that.srhsl) && Objects.equals(srzgj, that.srzgj) && Objects.equals(wxpszql, that.wxpszql) && Objects.equals(djzql, that.djzql);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, gsmc, ywmc, cym, agdm, agjc, bgdm, bgjc, hgdm, hgjc, zqlb, sshy, ssjys, sszjhhy, zjl, frdb, dm, dsz, zqswdb, dlds, lxdh, dzxx, cz, gswz, bgdz, zcdz, qy, yzbm, zczb, gsdj, gyrs, glryrs, lssws, kjssws, gsjj, jyfw, clrq, ssrq, wsfxrq, fxfs, fxsyl, fxl, mgmz, mgfxj, fxfy, fxzsz, mjzjje, srkpj, srspj, srhsl, srzgj, wxpszql, djzql);
    }
}

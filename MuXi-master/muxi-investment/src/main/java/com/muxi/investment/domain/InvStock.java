package com.muxi.investment.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.muxi.common.annotation.Excel;
import com.muxi.common.core.domain.BaseEntity;

import java.util.Objects;

/**
 * 沪深A股对象 inv_stock
 *
 * @author wenyong.yang
 * @date 2022-05-03
 */
public class InvStock extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 股票代码
     */
    @Excel(name = "股票代码")
    private String code;

    /**
     * 股票简称
     */
    @Excel(name = "股票简称")
    private String name;

    /**
     * 所属市场
     */
    @Excel(name = "所属市场")
    private String market;


    public InvStock(String code, String name, String market) {
        this.code = code;
        this.name = name;
        this.market = market;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getMarket() {
        return market;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("code", getCode())
                .append("name", getName())
                .append("market", getMarket())
                .toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvStock)) return false;
        InvStock invStock = (InvStock) o;
        return Objects.equals(code, invStock.code) && Objects.equals(name, invStock.name) && Objects.equals(market, invStock.market);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, market);
    }
}

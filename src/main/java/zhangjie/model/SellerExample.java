package zhangjie.model;

import java.util.ArrayList;
import java.util.List;

public class SellerExample extends BaseExample{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table seller
     *
     * @mbg.generated Mon Feb 18 10:43:23 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table seller
     *
     * @mbg.generated Mon Feb 18 10:43:23 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table seller
     *
     * @mbg.generated Mon Feb 18 10:43:23 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seller
     *
     * @mbg.generated Mon Feb 18 10:43:23 CST 2019
     */
    public SellerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seller
     *
     * @mbg.generated Mon Feb 18 10:43:23 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seller
     *
     * @mbg.generated Mon Feb 18 10:43:23 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seller
     *
     * @mbg.generated Mon Feb 18 10:43:23 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seller
     *
     * @mbg.generated Mon Feb 18 10:43:23 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seller
     *
     * @mbg.generated Mon Feb 18 10:43:23 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seller
     *
     * @mbg.generated Mon Feb 18 10:43:23 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seller
     *
     * @mbg.generated Mon Feb 18 10:43:23 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seller
     *
     * @mbg.generated Mon Feb 18 10:43:23 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seller
     *
     * @mbg.generated Mon Feb 18 10:43:23 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seller
     *
     * @mbg.generated Mon Feb 18 10:43:23 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table seller
     *
     * @mbg.generated Mon Feb 18 10:43:23 CST 2019
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdSellerIsNull() {
            addCriterion("id_seller is null");
            return (Criteria) this;
        }

        public Criteria andIdSellerIsNotNull() {
            addCriterion("id_seller is not null");
            return (Criteria) this;
        }

        public Criteria andIdSellerEqualTo(Integer value) {
            addCriterion("id_seller =", value, "idSeller");
            return (Criteria) this;
        }

        public Criteria andIdSellerNotEqualTo(Integer value) {
            addCriterion("id_seller <>", value, "idSeller");
            return (Criteria) this;
        }

        public Criteria andIdSellerGreaterThan(Integer value) {
            addCriterion("id_seller >", value, "idSeller");
            return (Criteria) this;
        }

        public Criteria andIdSellerGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_seller >=", value, "idSeller");
            return (Criteria) this;
        }

        public Criteria andIdSellerLessThan(Integer value) {
            addCriterion("id_seller <", value, "idSeller");
            return (Criteria) this;
        }

        public Criteria andIdSellerLessThanOrEqualTo(Integer value) {
            addCriterion("id_seller <=", value, "idSeller");
            return (Criteria) this;
        }

        public Criteria andIdSellerIn(List<Integer> values) {
            addCriterion("id_seller in", values, "idSeller");
            return (Criteria) this;
        }

        public Criteria andIdSellerNotIn(List<Integer> values) {
            addCriterion("id_seller not in", values, "idSeller");
            return (Criteria) this;
        }

        public Criteria andIdSellerBetween(Integer value1, Integer value2) {
            addCriterion("id_seller between", value1, value2, "idSeller");
            return (Criteria) this;
        }

        public Criteria andIdSellerNotBetween(Integer value1, Integer value2) {
            addCriterion("id_seller not between", value1, value2, "idSeller");
            return (Criteria) this;
        }

        public Criteria andNameSellerIsNull() {
            addCriterion("name_seller is null");
            return (Criteria) this;
        }

        public Criteria andNameSellerIsNotNull() {
            addCriterion("name_seller is not null");
            return (Criteria) this;
        }

        public Criteria andNameSellerEqualTo(String value) {
            addCriterion("name_seller =", value, "nameSeller");
            return (Criteria) this;
        }

        public Criteria andNameSellerNotEqualTo(String value) {
            addCriterion("name_seller <>", value, "nameSeller");
            return (Criteria) this;
        }

        public Criteria andNameSellerGreaterThan(String value) {
            addCriterion("name_seller >", value, "nameSeller");
            return (Criteria) this;
        }

        public Criteria andNameSellerGreaterThanOrEqualTo(String value) {
            addCriterion("name_seller >=", value, "nameSeller");
            return (Criteria) this;
        }

        public Criteria andNameSellerLessThan(String value) {
            addCriterion("name_seller <", value, "nameSeller");
            return (Criteria) this;
        }

        public Criteria andNameSellerLessThanOrEqualTo(String value) {
            addCriterion("name_seller <=", value, "nameSeller");
            return (Criteria) this;
        }

        public Criteria andNameSellerLike(String value) {
            addCriterion("name_seller like", value, "nameSeller");
            return (Criteria) this;
        }

        public Criteria andNameSellerNotLike(String value) {
            addCriterion("name_seller not like", value, "nameSeller");
            return (Criteria) this;
        }

        public Criteria andNameSellerIn(List<String> values) {
            addCriterion("name_seller in", values, "nameSeller");
            return (Criteria) this;
        }

        public Criteria andNameSellerNotIn(List<String> values) {
            addCriterion("name_seller not in", values, "nameSeller");
            return (Criteria) this;
        }

        public Criteria andNameSellerBetween(String value1, String value2) {
            addCriterion("name_seller between", value1, value2, "nameSeller");
            return (Criteria) this;
        }

        public Criteria andNameSellerNotBetween(String value1, String value2) {
            addCriterion("name_seller not between", value1, value2, "nameSeller");
            return (Criteria) this;
        }

        public Criteria andAddressSellerIsNull() {
            addCriterion("address_seller is null");
            return (Criteria) this;
        }

        public Criteria andAddressSellerIsNotNull() {
            addCriterion("address_seller is not null");
            return (Criteria) this;
        }

        public Criteria andAddressSellerEqualTo(String value) {
            addCriterion("address_seller =", value, "addressSeller");
            return (Criteria) this;
        }

        public Criteria andAddressSellerNotEqualTo(String value) {
            addCriterion("address_seller <>", value, "addressSeller");
            return (Criteria) this;
        }

        public Criteria andAddressSellerGreaterThan(String value) {
            addCriterion("address_seller >", value, "addressSeller");
            return (Criteria) this;
        }

        public Criteria andAddressSellerGreaterThanOrEqualTo(String value) {
            addCriterion("address_seller >=", value, "addressSeller");
            return (Criteria) this;
        }

        public Criteria andAddressSellerLessThan(String value) {
            addCriterion("address_seller <", value, "addressSeller");
            return (Criteria) this;
        }

        public Criteria andAddressSellerLessThanOrEqualTo(String value) {
            addCriterion("address_seller <=", value, "addressSeller");
            return (Criteria) this;
        }

        public Criteria andAddressSellerLike(String value) {
            addCriterion("address_seller like", value, "addressSeller");
            return (Criteria) this;
        }

        public Criteria andAddressSellerNotLike(String value) {
            addCriterion("address_seller not like", value, "addressSeller");
            return (Criteria) this;
        }

        public Criteria andAddressSellerIn(List<String> values) {
            addCriterion("address_seller in", values, "addressSeller");
            return (Criteria) this;
        }

        public Criteria andAddressSellerNotIn(List<String> values) {
            addCriterion("address_seller not in", values, "addressSeller");
            return (Criteria) this;
        }

        public Criteria andAddressSellerBetween(String value1, String value2) {
            addCriterion("address_seller between", value1, value2, "addressSeller");
            return (Criteria) this;
        }

        public Criteria andAddressSellerNotBetween(String value1, String value2) {
            addCriterion("address_seller not between", value1, value2, "addressSeller");
            return (Criteria) this;
        }

        public Criteria andGoodSellerIsNull() {
            addCriterion("good_seller is null");
            return (Criteria) this;
        }

        public Criteria andGoodSellerIsNotNull() {
            addCriterion("good_seller is not null");
            return (Criteria) this;
        }

        public Criteria andGoodSellerEqualTo(Integer value) {
            addCriterion("good_seller =", value, "goodSeller");
            return (Criteria) this;
        }

        public Criteria andGoodSellerNotEqualTo(Integer value) {
            addCriterion("good_seller <>", value, "goodSeller");
            return (Criteria) this;
        }

        public Criteria andGoodSellerGreaterThan(Integer value) {
            addCriterion("good_seller >", value, "goodSeller");
            return (Criteria) this;
        }

        public Criteria andGoodSellerGreaterThanOrEqualTo(Integer value) {
            addCriterion("good_seller >=", value, "goodSeller");
            return (Criteria) this;
        }

        public Criteria andGoodSellerLessThan(Integer value) {
            addCriterion("good_seller <", value, "goodSeller");
            return (Criteria) this;
        }

        public Criteria andGoodSellerLessThanOrEqualTo(Integer value) {
            addCriterion("good_seller <=", value, "goodSeller");
            return (Criteria) this;
        }

        public Criteria andGoodSellerIn(List<Integer> values) {
            addCriterion("good_seller in", values, "goodSeller");
            return (Criteria) this;
        }

        public Criteria andGoodSellerNotIn(List<Integer> values) {
            addCriterion("good_seller not in", values, "goodSeller");
            return (Criteria) this;
        }

        public Criteria andGoodSellerBetween(Integer value1, Integer value2) {
            addCriterion("good_seller between", value1, value2, "goodSeller");
            return (Criteria) this;
        }

        public Criteria andGoodSellerNotBetween(Integer value1, Integer value2) {
            addCriterion("good_seller not between", value1, value2, "goodSeller");
            return (Criteria) this;
        }

        public Criteria andBadSellerIsNull() {
            addCriterion("bad_seller is null");
            return (Criteria) this;
        }

        public Criteria andBadSellerIsNotNull() {
            addCriterion("bad_seller is not null");
            return (Criteria) this;
        }

        public Criteria andBadSellerEqualTo(Integer value) {
            addCriterion("bad_seller =", value, "badSeller");
            return (Criteria) this;
        }

        public Criteria andBadSellerNotEqualTo(Integer value) {
            addCriterion("bad_seller <>", value, "badSeller");
            return (Criteria) this;
        }

        public Criteria andBadSellerGreaterThan(Integer value) {
            addCriterion("bad_seller >", value, "badSeller");
            return (Criteria) this;
        }

        public Criteria andBadSellerGreaterThanOrEqualTo(Integer value) {
            addCriterion("bad_seller >=", value, "badSeller");
            return (Criteria) this;
        }

        public Criteria andBadSellerLessThan(Integer value) {
            addCriterion("bad_seller <", value, "badSeller");
            return (Criteria) this;
        }

        public Criteria andBadSellerLessThanOrEqualTo(Integer value) {
            addCriterion("bad_seller <=", value, "badSeller");
            return (Criteria) this;
        }

        public Criteria andBadSellerIn(List<Integer> values) {
            addCriterion("bad_seller in", values, "badSeller");
            return (Criteria) this;
        }

        public Criteria andBadSellerNotIn(List<Integer> values) {
            addCriterion("bad_seller not in", values, "badSeller");
            return (Criteria) this;
        }

        public Criteria andBadSellerBetween(Integer value1, Integer value2) {
            addCriterion("bad_seller between", value1, value2, "badSeller");
            return (Criteria) this;
        }

        public Criteria andBadSellerNotBetween(Integer value1, Integer value2) {
            addCriterion("bad_seller not between", value1, value2, "badSeller");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table seller
     *
     * @mbg.generated do_not_delete_during_merge Mon Feb 18 10:43:23 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table seller
     *
     * @mbg.generated Mon Feb 18 10:43:23 CST 2019
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
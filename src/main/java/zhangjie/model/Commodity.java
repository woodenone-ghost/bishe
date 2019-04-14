package zhangjie.model;

public class Commodity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.id
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.icon
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    private String icon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.name
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.price
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.category
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    private String category;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.business
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    private Integer business;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.characteristic
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    private String characteristic;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.sales_volume
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    private Integer salesVolume;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.evaluation
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    private String evaluation;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.id
     *
     * @return the value of commodity.id
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.id
     *
     * @param id the value for commodity.id
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.icon
     *
     * @return the value of commodity.icon
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.icon
     *
     * @param icon the value for commodity.icon
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.name
     *
     * @return the value of commodity.name
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.name
     *
     * @param name the value for commodity.name
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.price
     *
     * @return the value of commodity.price
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.price
     *
     * @param price the value for commodity.price
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.category
     *
     * @return the value of commodity.category
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.category
     *
     * @param category the value for commodity.category
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.business
     *
     * @return the value of commodity.business
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    public Integer getBusiness() {
        return business;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.business
     *
     * @param business the value for commodity.business
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    public void setBusiness(Integer business) {
        this.business = business;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.characteristic
     *
     * @return the value of commodity.characteristic
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    public String getCharacteristic() {
        return characteristic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.characteristic
     *
     * @param characteristic the value for commodity.characteristic
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic == null ? null : characteristic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.sales_volume
     *
     * @return the value of commodity.sales_volume
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    public Integer getSalesVolume() {
        return salesVolume;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.sales_volume
     *
     * @param salesVolume the value for commodity.sales_volume
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.evaluation
     *
     * @return the value of commodity.evaluation
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    public String getEvaluation() {
        return evaluation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.evaluation
     *
     * @param evaluation the value for commodity.evaluation
     *
     * @mbg.generated Fri Apr 12 09:06:57 CST 2019
     */
    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation == null ? null : evaluation.trim();
    }
}
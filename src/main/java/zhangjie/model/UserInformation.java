package zhangjie.model;

public class UserInformation {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinformation.account
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    private String account;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinformation.id
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinformation.password
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinformation.identity
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    private String identity;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinformation.account
     *
     * @return the value of userinformation.account
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinformation.account
     *
     * @param account the value for userinformation.account
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinformation.id
     *
     * @return the value of userinformation.id
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinformation.id
     *
     * @param id the value for userinformation.id
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinformation.password
     *
     * @return the value of userinformation.password
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinformation.password
     *
     * @param password the value for userinformation.password
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinformation.identity
     *
     * @return the value of userinformation.identity
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinformation.identity
     *
     * @param identity the value for userinformation.identity
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }
}
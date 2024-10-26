package models;

public class Customer {
    private String name;
    private String address;
    private String phone;

    private Customer(Builder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.phone = builder.phone;
    }

    public static class Builder {
        private String name;
        private String address;
        private String phone;

        public Builder(String name) {
            this.name = name;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}

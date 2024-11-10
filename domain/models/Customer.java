package domain.models;

public class Customer {
    private String name;
    private String address;
    private String phone;

    private Customer(Builder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.phone = builder.phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public static class Builder {
        private String name;
        private String address;
        private String phone;

        public Builder(String name) {
            this.name = name;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}

package DesignPatterns.CreationalDesignPatterns.Builder;

 class User {

     private String userName;
    private String email;
    private String userId;
    private User(UserBuilder builder){
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.email = builder.email;
    }

    public String getUsername(){
        return userName;
    }
    public String getUserId(){
        return userId;
    }
    public String getEmail(){
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    static class UserBuilder{
        private String userName;
        private String email;
        private String userId;

        public UserBuilder(){

        }

        public static UserBuilder builder(){
            return new UserBuilder();
        }
        public UserBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public User build(){
            return new User(this);
        }

    }
}
class Main{
    public static void main(String [] args){
        User user1 = new User.UserBuilder()
                .setUserId("1")
                .setEmail("prithvi@gmail.com").build();
        System.out.println(user1);

        User user2 = User.UserBuilder.builder()
                .setUserId("2")
                .setUserName("abc")
                .setEmail("abc@gmail.com").build();
        System.out.println(user2);
    }
}
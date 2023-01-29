package application;

public class Users {

        private int userDB_ID;
        private String userName;
        private String userEmail;
        private String userPassword;

        //SETS
        public void setUserDB_ID(int userDB_ID) {
            this.userDB_ID = userDB_ID;
        }
        public void setUserName(String userName) {
            this.userName = userName;
        }
        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }
        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        //GETS
        public int getUserDB_ID() {
            return userDB_ID;
        }
        public String getUserName() {
            return userName;
        }
        public String getUserEmail() {
            return userEmail;
        }
        public String getUserPassword() {
            return userPassword;
        }


}

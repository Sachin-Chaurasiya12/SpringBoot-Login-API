/*

    Spring Boot Login API  Copyright (C) 2026 Sachin Chaurasiya
    This program comes with ABSOLUTELY NO WARRANTY; for details type `show w'.
    This is free software, and you are welcome to redistribute it
    under certain conditions; type `show c' for details.

The hypothetical commands `show w' and `show c' should show the appropriate
parts of the General Public License.  Of course, your program's commands
might be different; for a GUI interface, you would use an "about box".

  You should also get your employer (if you work as a programmer) or school,
if any, to sign a "copyright disclaimer" for the program, if necessary.
For more information on this, and how to apply and follow the GNU GPL, see
<https://www.gnu.org/licenses/>.

  The GNU General Public License does not permit incorporating your program
into proprietary programs.  If your program is a subroutine library, you
may consider it more useful to permit linking proprietary applications with
the library.  If this is what you want to do, use the GNU Lesser General
Public License instead of this License.  But first, please read
<https://www.gnu.org/licenses/why-not-lgpl.html>.

*/
package com.example.security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
    @Id
    private int id;
    private String username;
    private String password;

    public Users(){}
    public Users(int id,String username,String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public String getusername() {
        return username;
    }
    public String getpassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setusername(String username) {
        this.username = username;
    }
    public void setpassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Users{" +
                "id : " + id + 
                ",username : " + username + "\'"  + 
                ",password : " + password + 
                "}";
    }
}

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
package com.example.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security.model.Users;
import com.example.security.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    @Autowired
    private AuthenticationManager authManager;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public Users register(Users user){
        user.setpassword(encoder.encode(user.getpassword()));
        return repo.save(user);
    }
    public String verify(Users user) {
        Authentication authentication = 
        authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getusername(), user.getpassword()));

        if(authentication.isAuthenticated()){
            return JwtService.generateToken(user);
        }
        return "Fail";
    }
    private void generateToken() {
        
    }
}

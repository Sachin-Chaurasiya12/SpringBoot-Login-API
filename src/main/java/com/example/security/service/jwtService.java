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

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.security.model.Users;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    private static String secretKey = "";
    public JwtService(){
        try {
            KeyGenerator key = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk = key.generateKey();
            secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    public static String generateToken(Users user) throws InvalidKeyException {
        Map<String,Object> claims = new HashMap<>();
    
        return Jwts.builder()
                    .claims()
                    .add(claims)
                    .subject(user.getusername())
                    .issuedAt(new Date(System.currentTimeMillis()))
                    .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 60))
                    .and()
                    .signWith(getkey())
                    .compact();
    }

    private static SecretKey getkey() {

        byte[] key = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(key);

    }
    public static String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }
    private static <T> T extractClaims(String token,Function<Claims,T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }
    private static Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) getkey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }
    public static  boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
    private static boolean isTokenExpired(String token) {
       return extractExpiration(token).before(new Date());
    }
    private static Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }
}

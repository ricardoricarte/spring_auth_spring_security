package authentication.authentication.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

  public UserPrincipal(authentication.authentication.modules.user.entities.User existsUser) {
      this.username = existsUser.getUsername();
      this.password = existsUser.getPassword();


     List<SimpleGrantedAuthority> authorities = new ArrayList<>();

      authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
      authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
      this.authorities = authorities;
  }

  public static UserPrincipal create(authentication.authentication.modules.user.entities.User existsUser) {
      return new UserPrincipal(existsUser);
  }
  private String username;
  private String password;
  private Collection<? extends GrantedAuthority> authorities;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
      return authorities;
  }

  @Override
  public String getPassword() {
      return password;
  }

  @Override
  public String getUsername() {
      return username;
  }

  @Override
  public boolean isAccountNonExpired() {
      return true;
  }

  @Override
  public boolean isAccountNonLocked() {
      return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
      return true;
  }

  @Override
  public boolean isEnabled() {
      return true;
  }
}
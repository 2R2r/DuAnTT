package com.duan.duantt.security;


import com.duan.duantt.Entity.NguoiDung;
import com.duan.duantt.Entity.VaiTro;
import com.duan.duantt.Repository.NguoiDungRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final NguoiDungRepository accountRepository;

    public CustomUserDetailsService(NguoiDungRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(VaiTro role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role.getTenVaiTro().toUpperCase()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<NguoiDung> accountOptional = accountRepository.findByTaiKhoan(username);
//        System.out.println("Ok2");
        if (!accountOptional.isPresent()) {
            throw new UsernameNotFoundException("Không tìm thấy người dùng với tên đăng nhập: " + username);
        }

        NguoiDung account = accountOptional.get();
//        System.out.println(account);
        return new User(account.getTaiKhoan(), account.getMatKhau(), getAuthorities(account.getVaiTro()));
    }
}
package iunsuccessful.demo.shiro.service.impl;

import com.google.common.base.Preconditions;
import iunsuccessful.demo.shiro.entity.User;
import iunsuccessful.demo.shiro.service.RoleService;
import iunsuccessful.demo.shiro.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author LiQZ on 2016/8/25.
 */
public class AuthorizingRealmImpl extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 权限验证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<Integer> roleIds = userService.findRoles(username);
        checkArgument(CollectionUtils.isNotEmpty(roleIds), "用户角色为空");
        authorizationInfo.setRoles(roleIds.stream().map(Object::toString).collect(Collectors.toSet()));
        authorizationInfo.setStringPermissions(roleService.findPermissions(roleIds));

        System.err.println(String.format("This user %s has permission: ", username));
        authorizationInfo.getStringPermissions().forEach(System.err::println);

        return authorizationInfo;
    }

    /**
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.err.println("doGetAuthenticationInfo token " + token);
        String username = (String) token.getPrincipal();
        User user = userService.selectByUsername(username);
        Preconditions.checkNotNull(user, "用户名密码错误");
        // 交给AuthenticatingRealm 使用 CredentialsMatcher 进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

}

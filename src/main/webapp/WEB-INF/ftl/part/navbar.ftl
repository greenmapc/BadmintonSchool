<#import "/spring.ftl" as spring/>

<div class="container asd">
    <nav class="navbar cap">
        <a class="navbar-brand nav-logotype" href=${action('MC#index')}>
            <img src="${context.getContextPath()}/assets/img/logo2.png" class="img-logo" alt="logo">
            <span class="text-logo">Школа бадминтона</span>
        </a>
        <div>
            <#if user??>
                <div class="user dropdown pull-right">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">
                        <span class="username"> ${user.getLogin().getUsername()} </span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href=${action('UC#personalProfile', 0, user.getUsername())} class="drop-menu"> Мой профиль </a></li>
                        <li class="divider"></li>
                        <li><a href=${action('UC#userSettings', 0, user.getUsername())} class="drop-menu"> Настройки </a></li>
                        <li class="divider"></li>
                        <li><a href="${context.getContextPath()}/logout" class="drop-menu"> Выход </a></li>

                    </ul>
                </div>
            <#else>
                <button type="button"
                        class="btn btn-primary sign-in"
                        onclick="window.location.href='${action('SC#signIn')}'">
                    Войти
                </button>
                <button type="button"
                        class="btn btn-primary sign-up"
                        onclick="window.location.href='${action('SC#signUp')}'">
                    Зарегистрироваться
                </button>
            </#if>
        </div>
    </nav>
    <hr size=2px width=100% align="center">
</div>

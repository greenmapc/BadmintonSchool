<div class="container content">
    <nav class="navbar navbar-expand-lg navbar-light">

        <div class="collapse navbar-collapse">
            <ul class="navbar-nav mr-auto">
                <li class="menu-item">
                    <a class="nav-link" href=${action('MC#index')}> Главная </a>
                </li>
                <li class="menu-item">
                    <a class="nav-link" href=${action('MC#getAthletes')}> Наши спортсмены </a>
                </li >
                <li class="menu-item">
                    <a class="nav-link" href=${action('MC#getCoaches')}> Наши тренеры </a>
                </li>
                <li class="menu-item">
                    <a class="nav-link" href=${action('NC#getNews')}> Новости </a>
                </li>


                <li class="menu-item-img li-vk-icon">
                    <a class="nav-link-img" href="http://vk.com">
                        <img src="${context.getContextPath()}/assets/img/icon-vk-link.png" alt="vk-logo">
                    </a>
                </li>
                <li class="menu-item-img li-insta-icon">
                    <a class="nav-link-img" href="http://instagram.com">
                        <img src="${context.getContextPath()}/assets/img/icon-insta-link.png" alt="insta-logo">
                    </a>
                </li>
            </ul>
        </div>
    </nav>
</div>

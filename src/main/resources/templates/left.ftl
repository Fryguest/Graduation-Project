<div class="sidebar" id="sidebar">
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'fixed')
        } catch (e) {
        }
    </script>

    <ul class="nav nav-list">
        <li>
            <a href="/index">
                <i class="icon-th-large"></i>
                <span class="menu-text"> 首页 </span>
            </a>
        </li>
        <li <#if taskType??  && (taskType >= 10000 && taskType < 20000)>class="active open"</#if>>
            <a href="#" class="dropdown-toggle">
                <i class="icon-arrow-down"></i>
                <span class="menu-text"> 学生入口 </span>
                <b class="arrow icon-angle-down"></b>
            </a>
            <ul class="submenu">
                <li <#if taskType?? && taskType == 10000>class="active"</#if>>
                    <a href="courseChosen">
                        <i class="icon-double-angle-right"></i>
                        选课
                    </a>
                </li>
            </ul>
        </li>
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-arrow-down"></i>
                <span class="menu-text"> 教师入口 </span>
                <b class="arrow icon-angle-down"></b>
            </a>
        </li>
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-arrow-down"></i>
                <span class="menu-text"> manager入口 </span>
                <b class="arrow icon-angle-down"></b>
            </a>
        </li>
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-arrow-down"></i>
                <span class="menu-text"> 敬请期待 </span>
                <b class="arrow icon-angle-down"></b>
            </a>
        </li>
    </ul><!-- /.nav-list -->

    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
    </div>

    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'collapsed')
        } catch (e) {
        }
    </script>
</div>
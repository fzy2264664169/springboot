$().ready(function(){
    tabChange();
});

function tabChange(){
    // var liHtml;
    // liHtml='<li class="l">All</li>'+
    // '<li class="l">Page One</li>'+
    // '<li class="l">Page Two</li>'+
    // '<li class="l">Page Three</li>';
    // $("#tab-nav").html(liHtml);

    liW();
    function liW(){  //li width
        var liWidth,
            ulWidth=$(".tct-nav").width(),
            liNum=$(".tct-nav li").length;
        liWidth=ulWidth/liNum;
        $(".tct-nav li").width(liWidth-1);
    }

    //default
    $(".tct-nav li").eq(0).addClass("active");
    $(".tct-con-list").eq(0).show();

    //li click
    $(".tct-nav li").click(function(){
        index=$(this).index();
        tab();
    });

    // tab-change function
    var index=0;
    function tab(){
        var nav=$(".tct-nav li").eq(index),
            tabCon=$(".tct-con-list").eq(index);
        nav.addClass("active");
        tabCon.show();
        $(".tct-nav li").not(nav).removeClass("active");
        $(".tct-con-list").not(tabCon).hide();
    }
}



all     "/WEB-INF/**", ignore: true

get     "/", forward: "/WEB-INF/pages/index.gtpl"

get     "/favicon.ico", redirect: "/images/gaelyk-small-favicon.png"

get     "/@ctx", forward: "/WEB-INF/groovy/@ctx/list.groovy"

//get     "/@ctx/@id", forward: "/WEB-INF/groovy/@ctx/get.groovy?id=@id"

//get     "/@ctx/create", forward: "/WEB-INF/pages/@ctx/create.gtpl"

post    "/@ctx", forward: "/WEB-INF/groovy/@ctx/save.groovy"

get     "/secure", forward: "/WEB-INF/pages/secure.gtpl"

get     "/free", forward: "/WEB-INF/pages/free.gtpl"

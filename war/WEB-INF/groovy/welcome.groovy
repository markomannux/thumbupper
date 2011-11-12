if (users.isUserLoggedIn()) {
    redirect "/goal/create"
} else {
    forward "/WEB-INF/pages/index.gtpl"
}

//Load FB SDK asyncronously
(function (d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id))
        return;
    js = d.createElement(s);
    js.id = id;
    js.src = "http://connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

//Inicializa SDK y obtiene el estado de la conexión
window.fbAsyncInit = function () {
    FB.init({
        appId: $('#app_id').val(),
        status: true,
        cookie: true,
        xfbml: true,
        version: 'v2.2' //'v2.1'
    });
};


$(document).ready(function () {
    var eventDetail = function () {

        var obj = $.parseJSON(
                '{ ' +
                ' "app_id": "' + $('#app_id').val() + '", ' +
                ' "app_secret": "' + $('#app_secret').val() + '", ' +
                ' "app_objUrl": "' + $('#app_objUrl').val() + '", ' +
                ' "app_privacy": "' + $('#app_privacy').val() + '", ' +
                ' "app_scopes": "' + $('#app_scopes').val() + '" ' +
                '}'
                );
        //$('#event_detail').html('');
        console.log(obj);
        return obj;
    };

    _eventDetail = eventDetail();

    $('#tag').focus();
    $(document).on('keyup', '#tag', function (e) {
        if (e.which === 13) {
            var userImage = 'http://graph.facebook.com/';
            
            
            _tagId = $('#tag').val();
            postToFB([{name: 'tagId', value: _tagId}]);

            _tagId = '';
            setTimeout(function () {

                userImage += _objUser.id + '/picture?type=large';
                $('.container-like-thnx #mainArea .share-it img').attr('src', userImage);
                $('.container-like-thnx #mainArea .share-it img').before('<h1><strong>Gracias: </strong>'+ _objUser.name +'</h1>');
                $('.container-like-thnx #mainArea .share-it img').after('<h1>Por compartir con tus amigos.</h1>');
            
                var app_user='/'+ _objUser.id +'/feed';
                var app_method = 'POST';                
                var app_privacy = { 'value': $('#app_privacy').val() };
                
                console.log('shareLink' );
                
                FB.api(
                    app_user,
                    app_method,
                    {
                        'access_token': _objUser.token,
                        'privacy': app_privacy,
                        'link': 'http://senso-lab.com', // _LINK_
                        'picture': 'http://senso-lab.com/static/img/senso_lab_fb.png', // _PICTURE_
                        'name': 'Senso Lab | Laboratorio Interactivo', // _TITLE_
                        'description': 'Senso conceptualiza y desarrolla aplicaciones interactivas que ofrecen '+
                                        'a los clientes un sinfin de posibilidades tecnológicas aplicadas al '+
                                        'marketing digital y sensorial.', // _DESC_
                        'place': '447480532052318' // _PLACE_ - Optional
                        
                    },
                    function (response) { 
                        if (!response) {
                            console.log('Error ocurred.');

                        } else if (response.error) {
                            console.log('Error: ' + response.error.message);

                        } else {
                            console.log('Success. Shared: ' + response.id);
                            //FadeOut on '.container-like'
                            $('.container-like').fadeOut(400);
                            $('.container-like').removeClass('visible').addClass('hidde');
                            //FadeInd '.container-like-thnx'
                            
                            //$('.share-it p').html('Gracias por darnos Like ' + _objUser.name );
                            $('.container-like-thnx').fadeIn(400);
                            $('.container-like-thnx').removeClass('hidde').addClass('visible');

                            setTimeout(function () {
                                //FadeOut '.container-like-thnx'
                                $('.container-like-thnx').fadeOut(400);
                                $('.container-like-thnx').removeClass('visible').addClass('hidde');
                                $('.container-like-thnx #mainArea .share-it h1').remove();
                                $('.container-like-thnx #mainArea .share-it img').removeAttr('src');
                                $('#tag').val('');
                            }, 3000);
                            setTimeout(function () {
                                //FadeIn '.container-like'
                                $(".container-like").fadeIn(400);
                                $('.container-like-thnx').removeClass('hidde').addClass('visible');

                            }, 3000);
                        }

                    }
                );
                //}                            

            }, 1500);
        } else {
            return false;

        }
    });
    
});
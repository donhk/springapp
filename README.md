# Minimal Spring APP

### Features

##### Web UI
It has a Web UI in which you can press a button and it will
reproduce a sound, this is to show how to load css/js/images
and mp3 files from the static resources folder.

##### REST GET with param
With `/?name=value` you can modify a text in the Web UI

##### REST GET 
From `/stats` it will return a json array
with data of the people who has pressed the button

##### REST POST
On `/log` it will receive post request with the geo
info of the user who pressed the button

#### Database
It has a self-contained h2 instance with a handy schema.sql
that can be used to create tables on boot.

#### Compilation
To create the jar execute

    ./gradlew bootJar
    
#### Execution  
To run the jar execute

    java -jar build/libs/minapp-1.0-SNAPSHOT.jar

#### TODO's
 - Add ssl
 - Add logging
 
https://donhk.dev

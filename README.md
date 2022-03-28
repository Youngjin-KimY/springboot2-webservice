# Springboot2-webservice

# Reason why this project start

"스프링 부트와 aws로 혼자구현하는 웹서비스"에서 필요한 내용을 찾아보다가 한번 쭉 따라가보기로 함
(following from a book which is "스프링 부트와 aws로 혼자구현하는 웹서비스")

# Differences
book was written at 2019, so some of dependency and artifact version is different
and also some of points are different. 
1. springboot 2.1.x -> 2.6.4(latest LTS)
2. gradle 5.x -> 7.x
3. junit 4 -> junit 5
   1. DB
      1. prd and test env are separated
         1. prd : mariadb
         2. test : h2
4. application.properties -> application.yml
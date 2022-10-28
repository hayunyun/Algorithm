-- 코드를 입력하세요
SELECT count(*) users from (select * from user_info where age is null) info
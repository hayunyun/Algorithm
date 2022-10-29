-- 코드를 입력하세요
SELECT a.apnt_no, p.pt_name, p.pt_no, a.mcdp_cd, d.dr_name, a.apnt_ymd 
from appointment a
join doctor d on (d.dr_id = a.mddr_id)
join patient p on (p.pt_no = a.pt_no)
where apnt_cncl_yn = 'N' 
and date_format(apnt_ymd, '%Y-%m-%d') = '2022-04-13'
and a.mcdp_cd = 'CS'
order by a.apnt_ymd

# 
# order by apnt_ymd

# select * from appointment
# where date_format(apnt_ymd, '%Y-%m-%d') = '2022-04-13'
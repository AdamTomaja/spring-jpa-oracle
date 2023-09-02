 alter session set "_ORACLE_SCRIPT" = true;
create user kurs2 identified by "kurs2";
grant connect, resource, dba to kurs2;
grant unlimited tablespace to kurs2;

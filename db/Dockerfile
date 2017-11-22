FROM mysql:5.7.20

ENV MYSQL_ROOT_PASSWORD root
ENV MYSQL_DATABASE db_finance

ADD dump.sql /docker-entrypoint-initdb.d/dump.sql

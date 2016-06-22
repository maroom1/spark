# MySQL 
echo "Preparing MySQL"
sudo yum install debconf-utils -y > /dev/null
debconf-set-selections <<< "mysql-server mysql-server/root_password password vagrant"
debconf-set-selections <<< "mysql-server mysql-server/root_password_again password vagrant"
echo "Installing MySQL"
sudo yum install mysql-server -y > /dev/null
sudo service mysqld start
mysql -u root -p
use mysql
GRANT ALL ON *.* to root@'localhost' IDENTIFIED BY 'vagrant';
FLUSH PRIVILEGES;
exit
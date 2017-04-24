sudo service postgresql start
sudo -u postgres psql -c "ALTER USER postgres WITH PASSWORD 'sabha123'"
sudo -u postgres psql -c "CREATE DATABASE brackets"
tail
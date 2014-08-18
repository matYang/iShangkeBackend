import sys
reload(sys)
sys.setdefaultencoding('utf8')

# INSERT INTO `permissions` (`ID`, `NAME`, `PATH`, `TAG`, `LAST_MODIFY_TIME`, `CREATE_TIME`, `ENABLED`, `DELETED`) VALUES (`1`, 'Login_N', 'POST/api/v2/user/login/phone', 'POST/api/v2/user/login/phone', now(), now(), '0', '0');
# POST/api/v2/user/login/phone
# INSERT INTO `role_permission` (`ROLE_ID`, `PERMISSION_ID`, `LAST_MODIFY_TIME`, `DELETED`) VALUES (4, 13, '2014-7-30 15:00:12', 0);

i = open("permissionapiwithname.txt")
op = open("p.txt", "w")
orp = open("rp.txt", "w")
count = 1
for line in i:
    words = line.split("$")
    print words[1]
    us = words[0].split("@")
    for u in us:
        if str(u) == "N":
            pre = "/"
            role = [4]
        if str(u) == "P":
            pre = "/p-"
            role = [3, 5]
        if str(u) == "A":
            pre = "/a-"
            role = [1, 2]
        path = words[2] + pre + "api/v2" + words[1]
        temp = "INSERT INTO `permissions` (`ID`, `NAME`, `PATH`, `TAG`, `LAST_MODIFY_TIME`, `CREATE_TIME`, `ENABLED`, `DELETED`) VALUES ( " + str(count) + ", \'" + words[3].split("\n")[0] + "\', \'" + path + "\', \'" + path + "\', now(), now(), 0, 0);\n"
        op.write(temp)
        for r in role:
            temp2 = "INSERT INTO `role_permission` (`ROLE_ID`, `PERMISSION_ID`, `LAST_MODIFY_TIME`, `DELETED`) VALUES (" + str(r) + ", " + str(count) + ", now(), 0);\n"  
            orp.write(temp2)  
        count = count + 1
        print temp
    # words = line.split("$") 
    # words[2] = words[2].split(" ",1)[0]
    # print words[2]
    # temp = "INSERT INTO `permissions` (`ID`, `NAME`, `PATH`, `TAG`, `LAST_MODIFY_TIME`, `CREATE_TIME`, `ENABLED`, `DELETED`) VALUES ( i\'" + words[0] + "\', \'" + words[1] + "\', \'" + words[2] + "\', \'" + words[2] + "\', now(), now(), 0, 0);\n"
    # print temp
    # m.write(temp)

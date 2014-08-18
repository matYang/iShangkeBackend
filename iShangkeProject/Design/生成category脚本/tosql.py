import sys
reload(sys)
sys.setdefaultencoding('utf8')

category = open("category.txt")
sql = open("sql.txt", "w")
h = 1
map1 = {}
map2 = {}
map3 = {}
for line in category:
    l = 1
    # print line
    if h == 1:
        ones = line.split("\n")[0].split("$")
        for one in ones:
            key = str(l - 1)
            value = "0" + key
            map1[key] = value
            temp = "INSERT INTO `category` (`VALUE`, `NAME`, `RANK`, `LAST_MODIFY_TIME`, `CREATE_TIME`, `ENABLED`, `DELETED`) VALUES (\'" + value + "', '" + one + "', NULL, now(), now(), 0, 0);\n"
            print temp
            sql.write(temp)
            l = l + 1
        h = h + 1
    elif h == 2:
        twos = line.split("\n")[0].split("$")
        for two in twos:
            key = str(l - 1)
            if l <= 2:
                if l == 1:
                    ll = 1
                prevalue = map1["0"]
                value = prevalue + "0" + str(ll - 1)
                map2[key] = value
                temp = "INSERT INTO `category` (`VALUE`, `NAME`, `RANK`, `LAST_MODIFY_TIME`, `CREATE_TIME`, `ENABLED`, `DELETED`) VALUES (\'" + value + "', '" + two + "', NULL, now(), now(), 0, 0);\n"
                print temp
                sql.write(temp)
                ll = ll + 1
            elif l <= 6:
                if l == 3:
                    ll = 1
                prevalue = map1["1"]
                value = prevalue + "0" + str(ll - 1)
                map2[key] = value
                temp = "INSERT INTO `category` (`VALUE`, `NAME`, `RANK`, `LAST_MODIFY_TIME`, `CREATE_TIME`, `ENABLED`, `DELETED`) VALUES (\'" + value + "', '" + two + "', NULL, now(), now(), 0, 0);\n"
                print temp
                sql.write(temp)
                ll = ll + 1
            elif l <= 11:
                if l == 7:
                    ll = 1
                prevalue = map1["2"]
                value = prevalue + "0" + str(ll - 1)
                map2[key] = value
                temp = "INSERT INTO `category` (`VALUE`, `NAME`, `RANK`, `LAST_MODIFY_TIME`, `CREATE_TIME`, `ENABLED`, `DELETED`) VALUES (\'" + value + "', '" + two + "', NULL, now(), now(), 0, 0);\n"
                print temp
                sql.write(temp)
                ll = ll + 1
            else:
                if l == 12:
                    ll = 1
                prevalue = map1["3"]
                value = prevalue + "0" + str(ll - 1)
                map2[key] = value
                temp = "INSERT INTO `category` (`VALUE`, `NAME`, `RANK`, `LAST_MODIFY_TIME`, `CREATE_TIME`, `ENABLED`, `DELETED`) VALUES (\'" + value + "', '" + two + "', NULL, now(), now(), 0, 0);\n"
                print temp
                sql.write(temp)
                ll = ll + 1            
            l = l + 1
        h = h + 1
    else:
        ths = line.split("\n")[0].split("$")
        for th in ths:
            if (h - 3) < 10:
                value = "0" + str(h - 3)
            else:
                value = str(h - 3)
            prevalue = map2[str(l - 1)]
            value = prevalue + value
            if th != "@":
                temp = "INSERT INTO `category` (`VALUE`, `NAME`, `RANK`, `LAST_MODIFY_TIME`, `CREATE_TIME`, `ENABLED`, `DELETED`) VALUES (\'" + value + "', '" + th + "', NULL, now(), now(), 0, 0);\n"
                print temp
                sql.write(temp)
            l = l + 1
        h = h + 1
        

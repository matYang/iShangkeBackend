import sys
reload(sys)
sys.setdefaultencoding('utf8')

i = open("permissionapi.txt")
k = open("permissionapiwithname.txt", "w")
for line2 in i:
    temp2 = line2.split("$")
    j = open("withname.txt")
    print str(temp2[1] + temp2[2].split("\n")[0])
    for line in j:
        temp = line.split("$")
        print "",str(temp[1] + temp[2].split(" ")[0])
        if (str(temp2[1] + temp2[2].split("\n")[0]) == str(temp[1] + temp[2].split(" ")[0])):
            line3 = line2.split("\n")[0] + "$" + str(temp[0]) + "\n"
            print line3
            k.write(line3)
    print temp[1].split("\n")[0]
    j.close()

    print "xxxxoooo"

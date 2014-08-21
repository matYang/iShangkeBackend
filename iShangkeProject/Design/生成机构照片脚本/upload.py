import sys
import urllib2
import poster
import simplejson
import os
import os.path
from poster.streaminghttp import register_openers  

reload(sys)
sys.setdefaultencoding('utf8')
register_openers()  

def upload(filename):
    url = 'http://admin.ishangke.cn/a-api/v2/classPhoto/upload'
    method = "POST"
    httpHandler = urllib2.HTTPHandler(debuglevel=1) 

    params = {'file':open(filename, 'rb'), 'partnerId' : 1} 
    datagen, headers = poster.encode.multipart_encode(params) 

    headers["X-MOBILE-ISHANGKE-SESSION"] = "0AD5146D8B79212DD4EA612B068B0B67D0A905C85C5B3D3829FDA5190EB4C306"
    request = urllib2.Request(url, datagen, headers)
    result = urllib2.urlopen(request) 

    strResponse = result.read() 
    type = sys.getfilesystemencoding() 
    result = strResponse.decode("UTF-8", "ignore").encode(type) 
    return simplejson.loads(result)["imgUrl"]

picsql = open("picsql.txt", "w")

# insert into `class_photo`(`ID`,`PARTNER_ID`,`IMG_URL`,`TITLE`,`DESCRIPTION`,`LAST_MODIFY_TIME`,`CREATE_TIME`,`ENABLED`,`DELETED`,`SNAPSHOT_URL`) values ('1','1','http://classroomimgbucket.oss-cn-hangzhou.aliyuncs.com/1/classPhotop1i1t1408262795419-1f58eeaa7b3c7d9f6ffcce67f2f95183.png',null,null,'2014-08-17 16:07:09','2014-08-16 22:05:25','0','0',null);

basedir = "picture"
i = 1
for parent,dirnames,filenames in os.walk(basedir):   
    if len(dirnames) == 0: 
        partnerId = parent.split("/")[1]
        print "partnerId", partnerId
        # print "parent:", parent
        # print "dirnames:", dirnames
        # print "filenames:", filenames
        for filename in filenames:
            fullName = str(parent) + "/" + str(filename)
            print "full name:", fullName
            url = upload(fullName)
            sql = "insert into `class_photo`(`ID`,`PARTNER_ID`,`IMG_URL`,`LAST_MODIFY_TIME`,`CREATE_TIME`,`ENABLED`,`DELETED`) values (" + str(i) + "," + partnerId +",'" + url + "',now(),now(),'0','0');\n"
            i = i + 1
            print sql
            picsql.write(sql)
        print
    # for dirname in  dirnames:
    #     print "parent is:", parent
    #     print "dirname is:", dirname
    #     print "filenames", filenames

    # for filename in filenames:                        
    #     # print "parent is:" + parent
    #     print "filename is:" + filename
    #     print "the full name of the file is:", os.path.join(parent,filename)

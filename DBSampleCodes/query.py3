import mysql.connector
try:
    # Open database connection
    conn = mysql.connector.connect(host="localhost", user="julian", passwd="admin123", db="demo", charset="utf8")
    cursor = conn.cursor()  # prepare a cursor object 
    sql = "select id, name, score from Student where score >= %s"
    data = (80,)
    cursor.execute(sql, data)   # Execute the SQL command
    for (id, name, score) in cursor:
        print("{0}, {1}, 的分數是 {2}".format(id, name, score))
except mysql.connector.Error as e:
    print(str(e))
    print("查詢失敗")
except Exception as e:
    print(str(e))
finally:
    if conn is not None:
        conn.close()

import mysql.connector
try:
    # Open database connection
    conn = mysql.connector.connect(host="localhost", user="julian", passwd="admin123", db="demo", charset="utf8")
    cursor = conn.cursor()  # prepare a cursor object 
    sql = "insert into Student values (%s, %s, %s, %s)"
    data = (99, 'lee','2008-12-09',81.5)
    cursor.execute(sql, data)  # Execute the SQL command
    conn.commit()
    print("新增成功")
except mysql.connector.Error as e:
    print(str(e))
    print("新增失敗")
except Exception as e:
    print(str(e))
    conn.rollback()
finally:
    if conn is not None:
        conn.close()

from flask import Flask
app = Flask(__name__)

count = 0

@app.route('/')
def index():
	global count
	count += 1
	
	return 'Hello from application' + str(count)

@app.route('/hello')
def index():
	global count2
	count2 += 1
	
	return 'Hello world! ' + str(count2)	

if __name__ == '__main__':
	app.run(host='0.0.0.0')

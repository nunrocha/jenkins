FROM  python:3.8-slim-buster
COPY ./app/requirements.txt /app/requirements.txt
WORKDIR /app
RUN pip install --upgrade -r requirements.txt
COPY ./app/app.py /app
ENTRYPOINT ["python"]
CMD ["app.py"]
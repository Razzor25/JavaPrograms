uploadFile(file: File, metadata: any = {}): Observable<any> {
    return new Observable<any>(subscription => {
      this.getAuthHeader().subscribe(tkn => {
        //get blob URL
        const initBody = {
          "expiryDate": "2030/12/28",
          "externalId": "1",
          "fileName": file.name,
          "virusScanStatus": "false"
        }
        // Goes to DMS, Get file Metadata & Blob URL
        this.httpClient.post(this.httpUrl, initBody, {
          headers: new HttpHeaders({ Authorization: tkn }),
          params: {
            metadata: JSON.stringify(metadata),
            searchTerms: ""
          }
        }).subscribe(metaInfo => {

          const blobUrl = metaInfo["attachments"][0].url;
          // Posting File Data to Bobl URL
          this.httpClient.put(blobUrl, file, {
            headers: {
              "x-ms-blob-type": "BlockBlob",
              "x-ms-blob-content-disposition": "attachment" // Needed for download functionality
            },
            observe: 'events',
            reportProgress: true
          }).subscribe(blobRes => {
            if (blobRes.type === HttpEventType.UploadProgress) {
              subscription.next(blobRes)            }
            if (blobRes.type === HttpEventType.Response) {
              subscription.next({...blobRes, body: {...metaInfo}})
              subscription.complete();
            }
          }, err => {
            subscription.error(err)
            subscription.complete();
          })
        }, err => {
          subscription.error(err)
          subscription.complete();
        })
      }, err => {
        subscription.error(err)
        subscription.complete();
      })
    })
  }
